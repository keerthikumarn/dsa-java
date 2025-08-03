package com.masking.demo;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class MaskingRepo {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/masking";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";

	public static Set<String> getMaskedColumns(String tableName) {
		Set<String> maskedColumns = new HashSet<>();
		String query = "SELECT column_name FROM masking_config WHERE table_name = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, tableName);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				maskedColumns.add(resultSet.getString("column_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maskedColumns;
	}
}
