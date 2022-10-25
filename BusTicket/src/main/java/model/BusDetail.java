package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusDetail {
	private Bus bus;
	private TravelAdmin travels;
	private Routes routes;
	
	
	public BusDetail(ResultSet resultSet) {
		bus=new Bus();
		routes = new Routes();
		travels = new TravelAdmin();
		try {
			bus.setBusId(resultSet.getInt(1));
			bus.setTravelsId(resultSet.getInt(2));
			bus.setBusNumber(resultSet.getString(3));
			bus.setBusType(resultSet.getString(4));
			bus.setSeatTypeId(resultSet.getInt(5));
			bus.setTotalseats(resultSet.getInt(6));
			bus.setRating(resultSet.getInt(7));
			travels.setTravelId(resultSet.getInt(8));
			travels.setEmailId(resultSet.getString(9));
			travels.setTravelsName(resultSet.getString(10));
			travels.setPassword(resultSet.getString(11));
			routes.setRouteId(resultSet.getInt(12));
			routes.setScheduleId(resultSet.getInt(13));
			routes.setStartPlace(resultSet.getString(14));
			routes.setEndPlace(resultSet.getString(15));
			routes.setTravelStartDate(resultSet.getDate(16).toLocalDate());
			routes.setTravelEndDate(resultSet.getDate(17).toLocalDate());
			routes.setTravelStartTime(resultSet.getTime(18).toLocalTime());
			routes.setTravelEndTime(resultSet.getTime(19).toLocalTime());
			routes.setTravelFare(resultSet.getDouble(20));
			routes.setTimeToReach(resultSet.getDouble(21));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
}
