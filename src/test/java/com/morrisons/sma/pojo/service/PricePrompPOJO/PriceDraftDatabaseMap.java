package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

public class PriceDraftDatabaseMap {
	private PriceDraftDatabaseMap(){
		
	}
	
	private static final Logger LOGGER = Logger.getLogger(PriceDraftDatabaseMap.class.getName());
	public static List<PriceDraftDTO> copyProperties(ResultSet rs) {
		List<PriceDraftDTO> priceDraftDtoList = new ArrayList<>();
		
		try {
			while (rs.next()) {
				PriceDraftDTO priceDraftDTO = new PriceDraftDTO();
				priceDraftDTO.setEventId(rs.getString("eventid"));
				priceDraftDTO.setStoreid(rs.getInt("storeid"));
				priceDraftDTO.setProductid(rs.getString("pricechangeid"));
				priceDraftDTO.setEffectivedate(rs.getString("effectivedate"));
				priceDraftDTO.setSource(rs.getString("source"));
				priceDraftDTO.setId(rs.getInt("id"));
				priceDraftDTO.setProcessed(rs.getBoolean("processed"));

				priceDraftDtoList.add(priceDraftDTO);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return priceDraftDtoList;

	}

}
