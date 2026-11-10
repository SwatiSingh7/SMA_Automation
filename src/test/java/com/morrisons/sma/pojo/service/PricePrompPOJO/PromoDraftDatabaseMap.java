package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

public class PromoDraftDatabaseMap {
	private PromoDraftDatabaseMap(){
		
	}
	private static final Logger LOGGER = Logger.getLogger(PromoDraftDatabaseMap.class.getName());

	public static List<PromoDraftDTO> copyProperties(ResultSet rs) {
		List<PromoDraftDTO> promoDraftDtoList = new ArrayList<>();

		try {
			while (rs.next()) {
				PromoDraftDTO promoDraftDTO = new PromoDraftDTO();
				promoDraftDTO.setEventId(rs.getString("eventid"));
				promoDraftDTO.setStoreid(rs.getInt("storeid"));
				promoDraftDTO.setPromochangeid(rs.getString("promochangeid"));
				promoDraftDTO.setEffectivedate(rs.getString("effectivedate"));
				promoDraftDTO.setSource(rs.getString("source"));
				promoDraftDTO.setId(rs.getInt("id"));
				promoDraftDTO.setProcessed(rs.getBoolean("processed"));
				promoDraftDTO.setCreateddate(rs.getString("createddate"));
				promoDraftDTO.setModifydate(rs.getString("modifydate"));

				promoDraftDtoList.add(promoDraftDTO);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return promoDraftDtoList;

	}

}
