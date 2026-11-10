package com.morrisons.sma.page_objects.mobile;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.morrisons.common.utility.WebServicesRetry.log;

public class CountPODynamic {

    public void CountPODynamic(){
        log.info("Inside : " + CountsPO.class);
            }
    public String CountedProductsView = "//android.widget.TextView[@resource-id='ToReplace:id/product_count']~Xpath";
    public String WarehouseLocation = "//android.widget.TextView[@resource-id='ToReplace:id/scheduled_counts_department_name']~Xpath";
    public String Reviewlocation = "//android.widget.TextView[@resource-id='ToReplace:id/review_count_name']~Xpath";
    public String Confirm = "//android.widget.Button[@resource-id='ToReplace:id/confirmButton']~Xpath";
    public String Complete = "//android.widget.TextView[@resource-id='ToReplace:id/tv_count_value']~Xpath";
    public String CountedProductsView1 = "//android.widget.TextView[@resource-id='ToReplace:id/product_count']~Xpath";
    public String CountProduct = "//android.widget.TextView[@resource-id='ToReplace:id/scheduled_counts_product_name']~Xpath";
    public String EnterStockQty = "//android.widget.EditText[@resource-id='ToReplace:id/quantityEditText']~Xpath";
    public String EnterAddStockQty = "//android.widget.TextView[@resource-id='ToReplace:id/tv_count_value']~Xpath";
}
