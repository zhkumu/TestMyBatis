package test.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MuTypeHandler extends BaseTypeHandler<Date> {

	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			Date parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public Date getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		String date= rs.getString(columnName);
		if(date!=null&&!date.equals(""))
			try {
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return new Date();
	}

	@Override
	public Date getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String date= rs.getString(columnIndex);
		if(date!=null&&!date.equals(""))
			try {
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return new Date();
	}

	@Override
	public Date getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
