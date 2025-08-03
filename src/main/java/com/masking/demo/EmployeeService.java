package com.masking.demo;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmployeeService {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/masking";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";

	public Map<String, String> getEmployeeById(int employeeId) {
		Map<String, String> employeeData = new HashMap<>();
		String query = "SELECT * FROM employee WHERE id = ?";
		Set<String> maskedColumns = MaskingRepo.getMaskedColumns("employee");

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, employeeId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();

				for (int colIdx = 1; colIdx <= columnCount; colIdx++) {
					String columnName = metaData.getColumnName(colIdx);
					String value = resultSet.getString(colIdx);

					if (maskedColumns.contains(columnName)) {
						value = MaskingUtil.maskValue(columnName, value);
					}
					employeeData.put(columnName, value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeData;
	}
}
