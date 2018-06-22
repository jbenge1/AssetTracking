package com.assetTracking;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AssetMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Asset asset = new Asset();
		asset.setId(rs.getInt("ID"));
		asset.setSerialNumber(rs.getString("SerialNumber"));
		asset.setVendor(rs.getString("Vendor"));
		asset.setDisposalDate(rs.getDate("DisposalDate"));
		asset.setNotes(rs.getString("Notes"));
		return asset;
	}

}
