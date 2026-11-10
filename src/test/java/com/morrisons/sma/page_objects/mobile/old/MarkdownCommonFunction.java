package com.morrisons.sma.page_objects.mobile.old;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownEventBody;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownVO;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_MarkdownPercentage;
import com.morrisons.sma.pojo.service.ProductServicePOJO.Item;

public class MarkdownCommonFunction {

	public static void setMarkdownPostContent(Item productResponse, MarkdownEventBody mDBodyContent,
			MarkdownVO markdownJsonResp, String type) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		List<Markdown_MarkdownPercentage> mper = markdownJsonResp.getMarkdownPercentages();
		String mpercapstr = markdownJsonResp.getMarkdownCap().getPercentageCap();
		// System.out.println(" Percentage Cap is "+mpercapstr);
		Markdown_MarkdownPercentage MaxPercentage = mper.get(mper.size() - 1);
		String MaxPercentageStr = MaxPercentage.getPercentage().toString();
		String MaxPriceStr = MaxPercentage.getMarkdownPrice().toString();
		// System.out.println(" Max Percentage is "+MaxPercentageStr);
		// System.out.println(" Max price is "+MaxPriceStr);
		if (Integer.parseInt(mpercapstr) > Integer.parseInt(MaxPercentageStr)) {
			if (type == "fail") {
				assertTrue("Max Percentage is not equal to Cap Percentage", false);
			} else if (type == "MarkdownCap") {
				double mcapint = Integer.parseInt(markdownJsonResp.getMarkdownCap().getPercentageCap());
				int sellingPrice = Integer.parseInt(markdownJsonResp.getProduct().getCurrentSellingPrice());
				System.out.println("Selling Price" + sellingPrice);
				Double mpercap = (mcapint / 100) * sellingPrice;
				int mpercapint = (int) mpercap.intValue();
				System.out.println("Maximum Cap price is : " + mpercap);
				String mpricecapstr = Integer.toString(mpercapint);
				System.out.println("Maximum Cap Percentage is : " + mpricecapstr);
				mDBodyContent.setMarkedDownPrice(mpricecapstr);
				mDBodyContent.setPercentageMarkdown(mpercapstr);
			} else if (type == "MaxPercentage") {
				mDBodyContent.setMarkedDownPrice(MaxPriceStr);
				mDBodyContent.setPercentageMarkdown(MaxPercentageStr);
			} else {
				System.out.println("Outside Else");
			}
		}

		else {

			for (Markdown_MarkdownPercentage m : mper) {

				int flag = 0;
				if ((Integer.parseInt(m.getPercentage())) <= Integer.parseInt(mpercapstr)) {
					mDBodyContent.setMarkedDownPrice(m.getMarkdownPrice());
					mDBodyContent.setPercentageMarkdown(m.getPercentage());
					if ((Integer.parseInt(m.getPercentage())) == Integer.parseInt(mpercapstr)) {
						break;
					}

				}
			}
		}

		mDBodyContent.setMarkdownBarcode(markdownJsonResp.getProduct().getBarcode());
		mDBodyContent.setDepartmentId(productResponse.getCommercialHierarchy().getDepartmentNumber());
		mDBodyContent.setQuantity("1");

		if (productResponse.getCommercialHierarchy().getDepartmentNumber().contains("216"))
			mDBodyContent.setCategoryId("95");
		else if (productResponse.getCommercialHierarchy().getDepartmentNumber().contains("217"))
			mDBodyContent.setCategoryId("98");
		else if (productResponse.getCommercialHierarchy().getDepartmentNumber().contains("222"))
			mDBodyContent.setCategoryId("97");
		else if (productResponse.getCommercialHierarchy().getDepartmentNumber().contains("223"))
			mDBodyContent.setCategoryId("96");
		else if (productResponse.getCommercialHierarchy().getDepartmentNumber().contains("224"))
			mDBodyContent.setCategoryId("99");
		else if (productResponse.getCommercialHierarchy().getDepartmentNumber().contains("225"))
			mDBodyContent.setCategoryId("94");

		mDBodyContent.setMarkdownCreatedDate(dateFormat.format(date).toString());
	}

}
