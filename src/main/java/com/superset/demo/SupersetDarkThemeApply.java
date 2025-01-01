package com.superset.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SupersetDarkThemeApply {

	// Database connection details
	private static final String DB_URL = "jdbc:postgresql://localhost:8088/superset";
	private static final String DB_USER = "postgres";
	private static final String DB_PASS = "postgres";

	// Path to the custom dark theme CSS file
	private static final String CSS_FILE_PATH = "/home/hs_dark_theme.css";

	public static void main(String[] args) {
		try {
			// Read the custom CSS content from the file
			String cssContent = new String(Files.readAllBytes(Paths.get(CSS_FILE_PATH)));
			// Apply the dark theme to all dashboards
			applyDarkTheme(cssContent);
		} catch (IOException e) {
			System.err.println("Error reading CSS file: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Error applying dark theme: " + e.getMessage());
		}
	}

	private static void applyDarkTheme(String cssContent) throws Exception {
		// Establish a connection to the database
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			System.out.println("Connected to the database.");

			// Fetch all dashboard IDs
			String fetchDashboardsQuery = "SELECT * FROM dashboards where id = 1";
			try (Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(fetchDashboardsQuery)) {

				// Prepare the update statement
				String updateCssQuery = "UPDATE dashboards SET css = ? WHERE id = ?";
				try (PreparedStatement preparedStatement = connection.prepareStatement(updateCssQuery)) {

					// Iterate through each dashboard and update the CSS
					while (resultSet.next()) {
						int dashboardId = resultSet.getInt("id");

						preparedStatement.setString(1, cssContent);
						preparedStatement.setInt(2, dashboardId);
						preparedStatement.executeUpdate();

						System.out.println("Applied dark theme to dashboard ID: " + dashboardId);
					}
				}
			}

			System.out.println("Dark theme applied to all dashboards successfully.");
		}
	}
}
