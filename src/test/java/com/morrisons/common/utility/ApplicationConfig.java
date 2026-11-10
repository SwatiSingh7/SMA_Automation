package com.morrisons.common.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.morrisons.sma.pojo.service.PricePrompPOJO.StockInputExtract;
import com.morrisons.sma.pojo.service.PricePrompPOJO.StockNasLocation;
import com.morrisons.sma.pojo.service.PricePrompPOJO.StockRMSextractVerification;

public class ApplicationConfig {

    private DatabaseConfig priceDatabase;
    private DatabaseConfig testDatabase;
    private DatabaseConfig spaceDatabase;
    private DatabaseConfig promotionDatabase;
    private DatabaseConfig productDatabase;
    private DatabaseConfig priceCheckDatabase;
    private DatabaseConfig pcaMfsDatabase;
    private DatabaseConfig stockV2Databse;
    private DatabaseConfig wasteValidationDatabase;

    public DatabaseConfig cleanAndRotate;

    private UnixServerConfig spaceUnixServer;
    private UnixServerConfig promoPriceUnixServer;
    private UnixServerConfig productUnixServer;

    private UnixServerConfig stockv2Unixserver1;
    private UnixServerConfig stockv2Unixserver2;

    private UnixServerConfig unixUser;
    private ProxyConfig proxyConfiguration;

    @JsonProperty("actionConfiguration")
    private ActionConfiguration actionConfiguration;

    // endpoints headers
    private WebServiceHeaders promoServiceHeaders;
    private WebServiceHeaders bffServiceHeaders;
    private WebServiceHeaders productServiceHeaders;
    private WebServiceHeaders productSearchServiceHeaders;
    private WebServiceHeaders priceServiceHeaders;
    private WebServiceHeaders adaptersConfigServiceHeader;
    private WebServiceHeaders priceV2ServiceHeaders;
    private WebServiceHeaders configServiceHeaders;
    private WebServiceHeaders pcspcaServiceHeader;
    private WebServiceHeaders spaceServiceHearders;
    private WebServiceHeaders signageServiceHeader;
    private WebServiceHeaders priceCheckServiceHeaders;
    private WebServiceHeaders taskServiceHearders;

    // Stockv2 Headers
    private WebServiceHeaders stockV2ServiceHeaders;

    // product Service endpoints
    private UrlConfig getItem;
    private UrlConfig getItemEvents;
    private UrlConfig getItemSearch;

    // ProductHierarchyAdapter end-points
    private UrlConfig getAdapterConfig;
    private UrlConfig ecsViewService;
    private UrlConfig ecsLogonService;

    //

    // price Service endpoints
    private UrlConfig getCurrentPrice;
    private UrlConfig getOnDatePrice;
    private UrlConfig getPriceHistory;
    private UrlConfig getPriceChangeDetails;
    private UrlConfig getPriceHistoryForBFF;
    private UrlConfig getPriceOndateNewEndPoint;
    private UrlConfig getPriceNewEndPointWithoutOnDate;
    private UrlConfig getPriceEvent;
    private UrlConfig getPriceWithDate;

    // StockV2 service endpoints
    private UrlConfig getstockv2details;
    private UrlConfig getLogonService;
    private UrlConfig getGetgapLowhigh;

    // Price Hierarchy Adapter endpoints
    private UrlConfig getPriceAdapterConfig;

    // Promotion end-points
    private UrlConfig getPromotion;
    private UrlConfig getOnDatePromotion;
    private UrlConfig getActivePromotion;
    private UrlConfig getPromoEventStore;
    private UrlConfig getPromoEventProduct;
    private UrlConfig getPromoEventSince;

    // Promotion Hierarchy Adapter endpoints
    private UrlConfig getPromotionHierarchyConfig;

    // space service endpoints
    private UrlConfig getSpaceOndateStatus;
    private UrlConfig getSpaceOndateMinStatus;
    private UrlConfig getSpaceOnDate;
    private UrlConfig getSpaceLocation;
    public UrlConfig getSpaceMinOndate;
    public UrlConfig getSpaceStoreMinItemStatus;
    public UrlConfig getSpaceEvent;

    // BFF service endpoints
    private UrlConfig getBffOndate;
    private UrlConfig getBffService;
    private UrlConfig getBffOndateInvalidQueryParameter;

    // PCSPCA endpoints
    private UrlConfig getPriceCheckHistoryWithSince;
    private UrlConfig getPriceCheckHistoryWithUntil;
    private UrlConfig getPriceCheckHistoryWithSinceUntil;
    private UrlConfig getPriceCheckHistory;
    private UrlConfig getPriceCheckPricDayDiff;

    private UrlConfig getDomainRangeDetails;

    private StockV2ShellScripts stockV2ShellScripts;

    // MUP PriceV2Service
    private WebServiceConfig postPricev2Service;
    // MUP Config service
    private WebServiceConfig getConfigService;

    private NasLocation promoNASLocation;

    private NasLocation priceNASLocation;

    private StockNasLocation stockNasLocation;

    private StyleIdCsvMapping ecsStyleIdMappingCsv;

    private StockInputExtract rmsInputExtract;
    private StockRMSextractVerification rmsStockextractforverification;

    private WebElementEnv webElementEnviroment;

    private UserCredentials userCredentials;

    private UserKeys userKeys;
    /*
     * // MUP PriceV2Service private WebServiceConfig postPricev2Service; // MUP
     * Config service private WebServiceConfig getConfigService;
     */

    private WebServiceConfig stockInfo;
    private WebServiceConfig getDelivery;
    private WebServiceConfig getPrice;
    private WebServiceConfig getProduct;
    private WebServiceConfig postGLH;
    private WebServiceConfig loginServiceMarkdown;
    private WebServiceConfig printServiceMarkdown;
    private WebServiceConfig getMarkdownService;
    private WebServiceConfig getgapLowHigh;
    private WebServiceConfig walkIdDetails;
    private WebServiceConfig CountDetails;
    private WebServiceConfig deleteCounts;
    private UrlConfig getSchedules;
    private UrlConfig getDepartments;
    private UrlConfig getListItems;
    private UrlConfig getCategoryDepartments;
    private UrlConfig getForecastOrders;
    private UrlConfig getSOItemDetails;
    private UrlConfig getStoreWalks;
    private UrlConfig getStoreWalkForStore;
    private UrlConfig getStoreWalkForAttributes;
    private UrlConfig getStoreWalkCaptureType;
    private UrlConfig getSectionApiServices;
    private UrlConfig getSectionAttributesApiServices;
    private UrlConfig getAlertListCodecheckServices;
    private UserCredentialsConfig userService;

    private UrlConfig createWalkitem;
    private UrlConfig createStorewalk;

    private UrlConfig getallCapture;
    private UrlConfig getStoreWalkitems;
    private UrlConfig createCapture;

    private UrlConfig deleteStorewalk;
    private UrlConfig getWalkitem;

    private UrlConfig getCaptures;
    private UrlConfig getAmendOrders;
    private WebServiceeConfig userLogin;

    private UrlConfig getMarkdownDetails;
    private UrlConfig getMarkdownDetailsBeforeScan;
    private UrlConfig getBlueyonderService;
    private UrlConfig getMarkdownList;

    private UrlConfig deletePrintList;

    private CleanAndRotate_TestData cleanAndRotateTestData;


    private UrlConfig getStockAdjustment;
    private WebServiceHeaders stockAdjustmentServiceHeaders;

    private WebServiceConfig getRange;

    private WebServiceConfig postUserLogin;


    public UrlConfig getGetStockAdjustment() {
        return getStockAdjustment;
    }

    public WebServiceHeaders getStockAdjustmentServiceHeaders() {
        return stockAdjustmentServiceHeaders;
    }


    public void setStockAdjustmentServiceHeaders(WebServiceHeaders stockAdjustmentServiceHeaders) {
        this.stockAdjustmentServiceHeaders = stockAdjustmentServiceHeaders;
    }

    public void setGetStockAdjustment(UrlConfig getStockAdjustment) {
        this.getStockAdjustment = getStockAdjustment;
    }

    private WebServiceConfig getProductDetail;
    private WebServiceConfig postStorewalk;
    private WebServiceConfig getGlhSummary;

    private WebServiceConfig postStockTranfer;
    private WebServiceConfig postBasketV2;

    private WebServiceConfig postStockMovement;
    private WebServiceHeaders stockMovementServiceHeader;

    private WebServiceConfig getSpace;
    private WebServiceHeaders getSpaceServiceHeader;
    private WebServiceeConfig postECSAssociateLabel;
    private WebServiceeConfig postEselLabelDetails;

    public WebServiceeConfig getPostECSAssociateLabel() {
        return postECSAssociateLabel;
    }

    public void setPostECSAssociateLable(WebServiceeConfig postECSAssociateLabel) {
        this.postECSAssociateLabel = postECSAssociateLabel;
    }

    public UrlConfig getCreateCapture() {
        return createCapture;
    }

    public WebServiceeConfig getPostEselLabelDetails() {
        return postEselLabelDetails;
    }

    public void setPostEselLabelDetails(WebServiceeConfig postEselLabelDetails) {
        this.postEselLabelDetails = postEselLabelDetails;
    }

    public void setPostECSAssociateLabel(WebServiceeConfig postECSAssociateLabel) {
        this.postECSAssociateLabel = postECSAssociateLabel;
    }

    public UrlConfig getGetMarkdownDetailsBeforeScan() {
        return getMarkdownDetailsBeforeScan;
    }

    public void setGetMarkdownDetailsBeforeScan(UrlConfig getMarkdownDetailsBeforeScan) {
        this.getMarkdownDetailsBeforeScan = getMarkdownDetailsBeforeScan;
    }

    public void setCreateCapture(UrlConfig createCapture) {
        this.createCapture = createCapture;
    }

    public UrlConfig getGetStoreWalkitems() {
        return getStoreWalkitems;
    }

    public void setGetStoreWalkitems(UrlConfig getStoreWalkitems) {
        this.getStoreWalkitems = getStoreWalkitems;
    }

    public UrlConfig getGetallCapture() {
        return getallCapture;
    }

    public void setGetallCapture(UrlConfig getallCapture) {
        this.getallCapture = getallCapture;
    }

    public UrlConfig getGetDepartments() {
        return getDepartments;
    }

    public void setGetDepartments(UrlConfig getDepartments) {
        this.getDepartments = getDepartments;
    }

    public UrlConfig getGetSchedules() {
        return getSchedules;
    }

    public void setGetSchedules(UrlConfig getSchedules) {
        this.getSchedules = getSchedules;
    }

    private WebServiceConfig postMarkdownEvent;

    // Signage endpoints
    private UrlConfig getSignageLogon;
    private UrlConfig postEcsSignsWithoutOnDate;
    private UrlConfig postEcsSignsWithOnDate;

    private UrlConfig postDefaultLabel;
    private UrlConfig postExplicitLabel;

    private UrlConfig getSignId;

    // adapter
    private DatabaseConfig rangeAdapterDatabase;

    // rackspace UI
    private WebpageConfig jenkinsDetails;
    private WebpageConfig rackspaceDetails;

    // webpage Fcc admin
    private WebpageConfig fccadminCredentials;

    public WebpageConfig getFccadminCredentials() {
        return fccadminCredentials;
    }

    public void setFccadminCredentials(WebpageConfig fccadminCredentials) {
        this.fccadminCredentials = fccadminCredentials;
    }

    public UrlConfig getGetSignId() {
        return getSignId;
    }

    public void setGetSignId(UrlConfig getSignId) {
        this.getSignId = getSignId;
    }

    public UrlConfig getGetPriceWithDate() {
        return getPriceWithDate;
    }

    public void setGetPriceWithDate(UrlConfig getPriceWithDate) {
        this.getPriceWithDate = getPriceWithDate;
    }

    public WebpageConfig getJenkinsDetails() {
        return jenkinsDetails;
    }

    public void setJenkinsDetails(WebpageConfig jenkinsDetails) {
        this.jenkinsDetails = jenkinsDetails;
    }

    public WebpageConfig getRackspaceDetails() {
        return rackspaceDetails;
    }

    public void setRackspaceDetails(WebpageConfig rackspaceDetails) {
        this.rackspaceDetails = rackspaceDetails;
    }

    public DatabaseConfig getRangeAdapterDatabase() {
        return rangeAdapterDatabase;
    }

    public void setRangeAdapterDatabase(DatabaseConfig rangeAdapterDatabase) {
        this.rangeAdapterDatabase = rangeAdapterDatabase;
    }

    // StockV2 endpoint Getter Setter

    public UrlConfig getPostEcsSignsWithOnDate() {
        return postEcsSignsWithOnDate;
    }

    public WebServiceConfig getWalkIdDetails() {
        return walkIdDetails;
    }

    public void setWalkIdDetails(WebServiceConfig walkIdDetails) {
        this.walkIdDetails = walkIdDetails;
    }

    public UrlConfig getGetGetgapLowhigh() {
        return getGetgapLowhigh;
    }

    public void setGetGetgapLowhigh(UrlConfig getGetgapLowhigh) {
        this.getGetgapLowhigh = getGetgapLowhigh;
    }

    public WebServiceConfig getGetgapLowHigh() {
        return getgapLowHigh;
    }

    public void setGetgapLowHigh(WebServiceConfig getgapLowHigh) {
        this.getgapLowHigh = getgapLowHigh;
    }

    public UrlConfig getGetLogonService() {
        return getLogonService;
    }

    public void setGetLogonService(UrlConfig getLogonService) {
        this.getLogonService = getLogonService;
    }

    public UrlConfig getGetstockv2details() {
        return getstockv2details;
    }

    public void setGetstockv2details(UrlConfig getstockv2details) {
        this.getstockv2details = getstockv2details;
    }

    public void setPostEcsSignsWithOnDate(UrlConfig postEcsSignsWithOnDate) {
        this.postEcsSignsWithOnDate = postEcsSignsWithOnDate;
    }

    private UrlConfig getSpaceStoreStatus;

    public UrlConfig getGetSpaceStoreStatus() {
        return getSpaceStoreStatus;
    }

    public void setGetSpaceStoreStatus(UrlConfig getSpaceStoreStatus) {
        this.getSpaceStoreStatus = getSpaceStoreStatus;
    }

    public UrlConfig getGetDomainRangeDetails() {
        return getDomainRangeDetails;
    }

    public void setGetDomainRangeDetails(UrlConfig getDomainRangeDetails) {
        this.getDomainRangeDetails = getDomainRangeDetails;
    }

    // Database Getter Setter

    public DatabaseConfig getPriceDatabase() {
        return priceDatabase;
    }

    public DatabaseConfig getStockV2Databse() {
        return stockV2Databse;
    }

    public void setWasteValidationDatabase(DatabaseConfig wasteValidationDatabase) {
        this.wasteValidationDatabase = wasteValidationDatabase;
    }

    public DatabaseConfig getWasteValidationDatabseDatabse() {
        return wasteValidationDatabase;
    }

    public void setStockV2Databse(DatabaseConfig stockV2Databse) {
        this.stockV2Databse = stockV2Databse;
    }

    public void setPriceDatabase(DatabaseConfig priceDatabase) {
        this.priceDatabase = priceDatabase;
    }

    public DatabaseConfig getSpaceDatabase() {
        return spaceDatabase;
    }

    public void setSpaceDatabase(DatabaseConfig spaceDatabase) {
        this.spaceDatabase = spaceDatabase;
    }

    public void setCleanAndRotateDatabse(DatabaseConfig cleanAndRotate) {
        this.cleanAndRotate = cleanAndRotate;
    }

    public DatabaseConfig getCleanAndRotateDatabse() {
        return cleanAndRotate;
    }

    public DatabaseConfig getPromotionDatabase() {
        return promotionDatabase;
    }

    // StockV2 Headers getter setter

    public WebServiceHeaders getPriceCheckServiceHeaders() {
        return priceCheckServiceHeaders;
    }

    public WebServiceHeaders getStockV2ServiceHeaders() {
        return stockV2ServiceHeaders;
    }

    public void setStockV2ServiceHeaders(WebServiceHeaders stockV2ServiceHeaders) {
        this.stockV2ServiceHeaders = stockV2ServiceHeaders;
    }

    public void setPriceCheckServiceHeaders(WebServiceHeaders priceCheckServiceHeaders) {
        this.priceCheckServiceHeaders = priceCheckServiceHeaders;
    }

    public void setPromotionDatabase(DatabaseConfig promotionDatabase) {
        this.promotionDatabase = promotionDatabase;
    }

    public WebServiceConfig getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(WebServiceConfig stockInfo) {
        this.stockInfo = stockInfo;
    }

    public WebServiceConfig getGetDelivery() {
        return getDelivery;
    }

    public void setGetDelivery(WebServiceConfig getDelivery) {
        this.getDelivery = getDelivery;
    }

    public WebServiceConfig getGetPrice() {
        return getPrice;
    }

    public void setGetPrice(WebServiceConfig getPrice) {
        this.getPrice = getPrice;
    }

    public DatabaseConfig getProductDatabase() {
        return productDatabase;
    }

    public void setProductDatabase(DatabaseConfig productDatabase) {
        this.productDatabase = productDatabase;
    }

    public DatabaseConfig getPriceCheckDatabase() {
        return priceCheckDatabase;
    }

    public void setPriceCheckDatabase(DatabaseConfig priceCheckDatabase) {
        this.priceCheckDatabase = priceCheckDatabase;
    }

    public DatabaseConfig getPcaMfsDatabase() {
        return pcaMfsDatabase;
    }

    public void setPcaMfsDatabase(DatabaseConfig pcaMfsDatabase) {
        this.pcaMfsDatabase = pcaMfsDatabase;
    }

    // Unix Server Getter Setter

    public UnixServerConfig getSpaceUnixServer() {
        return spaceUnixServer;
    }

    public UnixServerConfig getStockv2Unixserver2() {
        return stockv2Unixserver2;
    }

    public void setStockv2Unixserver2(UnixServerConfig stockv2Unixserver2) {
        this.stockv2Unixserver2 = stockv2Unixserver2;
    }

    public UnixServerConfig getStockv2Unixserver1() {
        return stockv2Unixserver1;
    }

    public void setStockv2Unixserver1(UnixServerConfig stockv2Unixserver1) {
        this.stockv2Unixserver1 = stockv2Unixserver1;
    }

    public void setSpaceUnixServer(UnixServerConfig spaceUnixServer) {
        this.spaceUnixServer = spaceUnixServer;
    }

    public UnixServerConfig getPromoPriceUnixServer() {
        return promoPriceUnixServer;
    }

    public void setPromoPriceUnixServer(UnixServerConfig promoPriceUnixServer) {
        this.promoPriceUnixServer = promoPriceUnixServer;
    }

    public UnixServerConfig getProductUnixServer() {
        return productUnixServer;
    }

    public void setProductUnixServer(UnixServerConfig productUnixServer) {
        this.productUnixServer = productUnixServer;
    }

    // Config Getter Setter
    public ProxyConfig getProxyConfiguration() {
        return proxyConfiguration;
    }

    public void setProxyConfiguration(ProxyConfig proxyConfiguration) {
        this.proxyConfiguration = proxyConfiguration;
    }

    public ActionConfiguration getActionConfiguration() {
        return actionConfiguration;
    }

    public void setActionConfiguration(ActionConfiguration actionConfiguration) {
        this.actionConfiguration = actionConfiguration;
    }

    // Web Service Headers Getter Setter
    public WebServiceHeaders getPromoServiceHeaders() {
        return promoServiceHeaders;
    }

    public void setPromoServiceHeaders(WebServiceHeaders promoServiceHeaders) {
        this.promoServiceHeaders = promoServiceHeaders;
    }

    public WebServiceHeaders getBffServiceHeaders() {
        return bffServiceHeaders;
    }

    public void setBffServiceHeaders(WebServiceHeaders bffServiceHeaders) {
        this.bffServiceHeaders = bffServiceHeaders;
    }

    public WebServiceHeaders getProductServiceHeaders() {
        return productServiceHeaders;
    }

    public void setProductServiceHeaders(WebServiceHeaders productServiceHeaders) {
        this.productServiceHeaders = productServiceHeaders;
    }

    public WebServiceHeaders getPriceServiceHeaders() {
        return priceServiceHeaders;
    }

    public void setPriceServiceHeaders(WebServiceHeaders priceServiceHeaders) {
        this.priceServiceHeaders = priceServiceHeaders;
    }

    public WebServiceHeaders getAdaptersConfigServiceHeader() {
        return adaptersConfigServiceHeader;
    }

    public void setAdaptersConfigServiceHeader(WebServiceHeaders adaptersConfigServiceHeader) {
        this.adaptersConfigServiceHeader = adaptersConfigServiceHeader;
    }

    public WebServiceHeaders getPriceV2ServiceHeaders() {
        return priceV2ServiceHeaders;
    }

    public void setPriceV2ServiceHeaders(WebServiceHeaders priceV2ServiceHeaders) {
        this.priceV2ServiceHeaders = priceV2ServiceHeaders;
    }

    public WebServiceHeaders getConfigServiceHeaders() {
        return configServiceHeaders;
    }

    public void setConfigServiceHeaders(WebServiceHeaders configServiceHeaders) {
        this.configServiceHeaders = configServiceHeaders;
    }

    public WebServiceHeaders getPcspcaServiceHeader() {
        return pcspcaServiceHeader;
    }

    public void setPcspcaServiceHeader(WebServiceHeaders pcspcaServiceHeader) {
        this.pcspcaServiceHeader = pcspcaServiceHeader;
    }

    public WebServiceHeaders getSpaceServiceHearders() {
        return spaceServiceHearders;
    }

    public void setSpaceServiceHearders(WebServiceHeaders spaceServiceHearders) {
        this.spaceServiceHearders = spaceServiceHearders;
    }

    public WebServiceHeaders getProductSearchServiceHeaders() {
        return productSearchServiceHeaders;
    }

    public void setProductSearchServiceHeaders(WebServiceHeaders productSearchServiceHeaders) {
        this.productSearchServiceHeaders = productSearchServiceHeaders;
    }

    // Web Service Config Getter Setter
    public UrlConfig getGetItem() {
        return getItem;
    }

    public void setGetItem(UrlConfig getItem) {
        this.getItem = getItem;
    }

    public UrlConfig getGetItemEvents() {
        return getItemEvents;
    }

    public void setGetItemEvents(UrlConfig getItemEvents) {
        this.getItemEvents = getItemEvents;
    }

    public UrlConfig getGetCurrentPrice() {
        return getCurrentPrice;
    }

    public void setGetCurrentPrice(UrlConfig getCurrentPrice) {
        this.getCurrentPrice = getCurrentPrice;
    }

    public UrlConfig getGetOnDatePrice() {
        return getOnDatePrice;
    }

    public void setGetOnDatePrice(UrlConfig getOnDatePrice) {
        this.getOnDatePrice = getOnDatePrice;
    }

    public UrlConfig getGetPriceHistory() {
        return getPriceHistory;
    }

    public void setGetPriceHistory(UrlConfig getPriceHistory) {
        this.getPriceHistory = getPriceHistory;
    }

    public UrlConfig getGetPriceChangeDetails() {
        return getPriceChangeDetails;
    }

    public void setGetPriceChangeDetails(UrlConfig getPriceChangeDetails) {
        this.getPriceChangeDetails = getPriceChangeDetails;
    }

    public UrlConfig getGetPriceHistoryForBFF() {
        return getPriceHistoryForBFF;
    }

    public void setGetPriceHistoryForBFF(UrlConfig getPriceHistoryForBFF) {
        this.getPriceHistoryForBFF = getPriceHistoryForBFF;
    }

    public UrlConfig getGetPriceOndateNewEndPoint() {
        return getPriceOndateNewEndPoint;
    }

    public void setGetPriceOndateNewEndPoint(UrlConfig getPriceOndateNewEndPoint) {
        this.getPriceOndateNewEndPoint = getPriceOndateNewEndPoint;
    }

    public UrlConfig getGetPriceNewEndPointWithoutOnDate() {
        return getPriceNewEndPointWithoutOnDate;
    }

    public void setGetPriceNewEndPointWithoutOnDate(UrlConfig getPriceNewEndPointWithoutOnDate) {
        this.getPriceNewEndPointWithoutOnDate = getPriceNewEndPointWithoutOnDate;
    }

    public UrlConfig getGetPriceEvent() {
        return getPriceEvent;
    }

    public void setGetPriceEvent(UrlConfig getPriceEvent) {
        this.getPriceEvent = getPriceEvent;
    }

    public UrlConfig getGetPriceAdapterConfig() {
        return getPriceAdapterConfig;
    }

    public void setGetPriceAdapterConfig(UrlConfig getPriceAdapterConfig) {
        this.getPriceAdapterConfig = getPriceAdapterConfig;
    }

    public UrlConfig getGetPromotion() {
        return getPromotion;
    }

    public void setGetPromotion(UrlConfig getPromotion) {
        this.getPromotion = getPromotion;
    }

    public UrlConfig getGetOnDatePromotion() {
        return getOnDatePromotion;
    }

    public void setGetOnDatePromotion(UrlConfig getOnDatePromotion) {
        this.getOnDatePromotion = getOnDatePromotion;
    }

    public UrlConfig getGetActivePromotion() {
        return getActivePromotion;
    }

    public void setGetActivePromotion(UrlConfig getActivePromotion) {
        this.getActivePromotion = getActivePromotion;
    }

    public UrlConfig getGetPromoEventStore() {
        return getPromoEventStore;
    }

    public void setGetPromoEventStore(UrlConfig getPromoEventStore) {
        this.getPromoEventStore = getPromoEventStore;
    }

    public UrlConfig getGetPromoEventProduct() {
        return getPromoEventProduct;
    }

    public void setGetPromoEventProduct(UrlConfig getPromoEventProduct) {
        this.getPromoEventProduct = getPromoEventProduct;
    }

    public UrlConfig getGetPromoEventSince() {
        return getPromoEventSince;
    }

    public void setGetPromoEventSince(UrlConfig getPromoEventSince) {
        this.getPromoEventSince = getPromoEventSince;
    }

    public UrlConfig getGetPromotionHierarchyConfig() {
        return getPromotionHierarchyConfig;
    }

    public void setGetPromotionHierarchyConfig(UrlConfig getPromotionHierarchyConfig) {
        this.getPromotionHierarchyConfig = getPromotionHierarchyConfig;
    }

    public UrlConfig getGetSpaceOndateStatus() {
        return getSpaceOndateStatus;
    }

    public void setGetSpaceOndateStatus(UrlConfig getSpaceOndateStatus) {
        this.getSpaceOndateStatus = getSpaceOndateStatus;
    }

    /*
     * <<<<<<< HEAD
     *
     * public UrlConfig getGetSpaceEvent() { return getSpaceEvent; }
     *
     * public void setGetSpaceEvent(UrlConfig getSpaceEvent) {
     * this.getSpaceEvent = getSpaceEvent; =======
     */
    public UrlConfig getGetSpaceOndateMinStatus() {
        return getSpaceOndateMinStatus;
    }

    public void setGetSpaceOndateMinStatus(UrlConfig getSpaceOndateMinStatus) {
        this.getSpaceOndateMinStatus = getSpaceOndateMinStatus;
        // >>>>>>> 112cb54153ff520de6f2a4a5f2d81b4e4ffa22f9
    }

    public UrlConfig getGetSpaceOnDate() {
        return getSpaceOnDate;
    }

    public void setGetSpaceOnDate(UrlConfig getSpaceOnDate) {
        this.getSpaceOnDate = getSpaceOnDate;
    }

    public UrlConfig getGetSpaceLocation() {
        return getSpaceLocation;
    }

    public void setGetSpaceLocation(UrlConfig getSpaceLocation) {
        this.getSpaceLocation = getSpaceLocation;
    }

    public UrlConfig getGetSpaceMinOndate() {
        return getSpaceMinOndate;
    }

    public void setGetSpaceMinOndate(UrlConfig getSpaceMinOndate) {
        this.getSpaceMinOndate = getSpaceMinOndate;
    }

    public UrlConfig getGetSpaceStoreMinItemStatus() {
        return getSpaceStoreMinItemStatus;
    }

    public void setGetSpaceStoreMinItemStatus(UrlConfig getSpaceStoreMinItemStatus) {
        this.getSpaceStoreMinItemStatus = getSpaceStoreMinItemStatus;
    }

    public UrlConfig getGetSpaceEvent() {
        return getSpaceEvent;
    }

    public void setGetSpaceEvent(UrlConfig getSpaceEvent) {
        this.getSpaceEvent = getSpaceEvent;
    }

    public UrlConfig getGetBffOndate() {
        return getBffOndate;
    }

    public void setGetBffOndate(UrlConfig getBffOndate) {
        this.getBffOndate = getBffOndate;
    }

    public UrlConfig getGetBffService() {
        return getBffService;
    }

    public void setGetBffService(UrlConfig getBffService) {
        this.getBffService = getBffService;
    }

    public UrlConfig getGetPriceCheckHistoryWithSince() {
        return getPriceCheckHistoryWithSince;
    }

    public void setGetPriceCheckHistoryWithSince(UrlConfig getPriceCheckHistoryWithSince) {
        this.getPriceCheckHistoryWithSince = getPriceCheckHistoryWithSince;
    }

    public UrlConfig getGetPriceCheckHistoryWithSinceUntil() {
        return getPriceCheckHistoryWithSinceUntil;
    }

    public void setGetPriceCheckHistoryWithSinceUntil(UrlConfig getPriceCheckHistoryWithSinceUntil) {
        this.getPriceCheckHistoryWithSinceUntil = getPriceCheckHistoryWithSinceUntil;
    }

    public UrlConfig getGetPriceCheckHistory() {
        return getPriceCheckHistory;
    }

    public void setGetPriceCheckHistory(UrlConfig getPriceCheckHistory) {
        this.getPriceCheckHistory = getPriceCheckHistory;
    }

    public UrlConfig getGetPriceCheckPricDayDiff() {
        return getPriceCheckPricDayDiff;
    }

    public void setGetPriceCheckPricDayDiff(UrlConfig getPriceCheckPricDayDiff) {
        this.getPriceCheckPricDayDiff = getPriceCheckPricDayDiff;
    }

    public UrlConfig getGetItemSearch() {
        return getItemSearch;
    }

    public void setGetItemSearch(UrlConfig getItemSearch) {
        this.getItemSearch = getItemSearch;
    }

    // Shell Script Getter Setter

    public StockV2ShellScripts getStockV2ShellScripts() {
        return stockV2ShellScripts;
    }

    public void setStockV2ShellScripts(StockV2ShellScripts stockV2ShellScripts) {
        this.stockV2ShellScripts = stockV2ShellScripts;
    }

    // NAS Location getter setter

    public NasLocation getPromoNASLocation() {
        return promoNASLocation;
    }

    public StockNasLocation getStockNasLocation() {
        return stockNasLocation;
    }

    public void setStockNasLocation(StockNasLocation stockNasLocation) {
        this.stockNasLocation = stockNasLocation;
    }

    public void setPromoNASLocation(NasLocation promoNASLocation) {
        this.promoNASLocation = promoNASLocation;
    }

    public NasLocation getPriceNASLocation() {
        return priceNASLocation;
    }

    public void setPriceNASLocation(NasLocation priceNASLocation) {
        this.priceNASLocation = priceNASLocation;
    }

    public WebServiceConfig getPostPricev2Service() {
        return postPricev2Service;
    }

    public void setPostPricev2Service(WebServiceConfig postPricev2Service) {
        this.postPricev2Service = postPricev2Service;
    }

    public WebServiceConfig getGetConfigService() {
        return getConfigService;
    }

    public void setGetConfigService(WebServiceConfig getConfigService) {
        this.getConfigService = getConfigService;
    }

    public WebServiceConfig getPrintServiceMarkdown() {
        return printServiceMarkdown;
    }

    public void setPrintServiceMarkdown(WebServiceConfig printServiceMarkdown) {
        this.printServiceMarkdown = printServiceMarkdown;
    }

    public WebServiceConfig getLoginServiceMarkdown() {
        return loginServiceMarkdown;

    }

    public WebServiceConfig getPostGLH() {
        return postGLH;
    }

    public void setPostGLH(WebServiceConfig postGLH) {
        this.postGLH = postGLH;
    }

    public WebServiceConfig getDeleteCounts() {
        return deleteCounts;
    }

    public void setDeleteCounts(WebServiceConfig deleteCounts) {
        this.deleteCounts = deleteCounts;
    }

    public WebServiceConfig getCountDetails() {
        return CountDetails;
    }

    public void setCountDetails(WebServiceConfig countDetails) {
        CountDetails = countDetails;
    }

    public void setLoginServiceMarkdown(WebServiceConfig loginServiceMarkdown) {
        this.loginServiceMarkdown = loginServiceMarkdown;
    }

    public WebServiceConfig getGetProduct() {
        return getProduct;
    }

    public void setGetProduct(WebServiceConfig getProduct) {
        this.getProduct = getProduct;
    }

    public WebServiceConfig getGetMarkdownService() {
        return getMarkdownService;
    }

    public void setGetMarkdownService(WebServiceConfig getMarkdownService) {
        this.getMarkdownService = getMarkdownService;
    }

    public WebServiceConfig getPostMarkdownEvent() {
        return postMarkdownEvent;
    }

    public void setPostMarkdownEvent(WebServiceConfig postMarkdownEvent) {
        this.postMarkdownEvent = postMarkdownEvent;
    }

    public UrlConfig getGetPriceCheckHistoryWithUntil() {
        return getPriceCheckHistoryWithUntil;
    }

    public void setGetPriceCheckHistoryWithUntil(UrlConfig getPriceCheckHistoryWithUntil) {
        this.getPriceCheckHistoryWithUntil = getPriceCheckHistoryWithUntil;
    }

    public UrlConfig getEcsLogonService() {
        return ecsLogonService;
    }

    public void setEcsLogonService(UrlConfig ecsLogonService) {
        this.ecsLogonService = ecsLogonService;
    }

    public UrlConfig getGetAdapterConfig() {
        return getAdapterConfig;
    }

    public void setGetAdapterConfig(UrlConfig getAdapterConfig) {
        this.getAdapterConfig = getAdapterConfig;
    }

    public UrlConfig getEcsViewService() {
        return ecsViewService;
    }

    public void setEcsViewService(UrlConfig ecsViewService) {
        this.ecsViewService = ecsViewService;
    }

    public UrlConfig getBffOndateInvalidQueryParameter() {
        return getBffOndateInvalidQueryParameter;
    }

    public void setGetBffOndateInvalidQueryParameter(UrlConfig getGetBffOndateInvalidQueryParameter) {
        this.getBffOndateInvalidQueryParameter = getGetBffOndateInvalidQueryParameter;
    }

    public WebServiceHeaders getSignageServiceHeader() {
        return signageServiceHeader;
    }

    public void setSignageServiceHeader(WebServiceHeaders signageServiceHeader) {
        this.signageServiceHeader = signageServiceHeader;
    }

    public UrlConfig getGetSignageLogon() {
        return getSignageLogon;
    }

    public void setGetSignageLogon(UrlConfig getSignageLogon) {
        this.getSignageLogon = getSignageLogon;
    }

    public UrlConfig getPostEcsSignsWithoutOnDate() {
        return postEcsSignsWithoutOnDate;
    }

    public void setPostEcsSignsWithoutOnDate(UrlConfig postEcsSignsWithoutOnDate) {
        this.postEcsSignsWithoutOnDate = postEcsSignsWithoutOnDate;
    }

    public UrlConfig getGetBffOndateInvalidQueryParameter() {
        return getBffOndateInvalidQueryParameter;
    }

    public UrlConfig getPostDefaultLabel() {
        return postDefaultLabel;
    }

    public void setPostDefaultLabel(UrlConfig postDefaultLabel) {
        this.postDefaultLabel = postDefaultLabel;
    }

    public UrlConfig getPostExplicitLabel() {
        return postExplicitLabel;
    }

    public void setPostExplicitLabel(UrlConfig postExplicitLabel) {
        this.postExplicitLabel = postExplicitLabel;
    }

    public StyleIdCsvMapping getEcsStyleIdMappingCsv() {
        return ecsStyleIdMappingCsv;
    }

    public void setEcsStyleIdMappingCsv(StyleIdCsvMapping ecsStyleIdMappingCsv) {
        this.ecsStyleIdMappingCsv = ecsStyleIdMappingCsv;
    }

    public StockInputExtract getRmsInputExtract() {
        return rmsInputExtract;
    }

    public void setRmsInputExtract(StockInputExtract rmsInputExtract) {
        this.rmsInputExtract = rmsInputExtract;
    }

    public StockRMSextractVerification getRmsStockextractforverification() {
        return rmsStockextractforverification;
    }

    public WebElementEnv getWebElementEnviroment() {
        return webElementEnviroment;
    }

    public void setWebElementEnviroment(WebElementEnv webElementEnviroment) {
        this.webElementEnviroment = webElementEnviroment;
    }

    public void setRmsStockextractforverification(StockRMSextractVerification rmsStockextractforverification) {
        this.rmsStockextractforverification = rmsStockextractforverification;
    }

    public UrlConfig getGetListItems() {
        return getListItems;
    }

    public void setGetListItems(UrlConfig getListItems) {
        this.getListItems = getListItems;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public UserKeys getUserKeys() {
        return userKeys;
    }

    public void setUserKeys(UserKeys userKeys) {
        this.userKeys = userKeys;
    }

    public UrlConfig getGetCategoryDepartments() {
        return getCategoryDepartments;
    }

    public void setGetCategoryDepartments(UrlConfig getCategoryDepartments) {
        this.getCategoryDepartments = getCategoryDepartments;
    }

    public UrlConfig getGetForecastOrders() {
        return getForecastOrders;
    }

    public void setGetForecastOrders(UrlConfig getForecastOrders) {
        this.getForecastOrders = getForecastOrders;
    }

    public UrlConfig getGetSOItemDetails() {
        return getSOItemDetails;
    }

    public void setGetSOItemDetails(UrlConfig getSOItemDetails) {
        this.getSOItemDetails = getSOItemDetails;
    }

    public UrlConfig getGetStoreWalks() {
        return getStoreWalks;
    }

    public void setGetStoreWalks(UrlConfig getStoreWalks) {
        this.getStoreWalks = getStoreWalks;
    }

    public UrlConfig getGetStoreWalkForStore() {
        return getStoreWalkForStore;
    }

    public void setGetStoreWalkForStore(UrlConfig getStoreWalkForStore) {
        this.getStoreWalkForStore = getStoreWalkForStore;
    }

    public UrlConfig getGetStoreWalkForAttributes() {
        return getStoreWalkForAttributes;
    }

    public void setGetStoreWalkForAttributes(UrlConfig getStoreWalkForAttributes) {
        this.getStoreWalkForAttributes = getStoreWalkForAttributes;
    }

    public UrlConfig getGetStoreWalkCaptureType() {
        return getStoreWalkCaptureType;
    }

    public void setGetStoreWalkCaptureType(UrlConfig getStoreWalkCaptureType) {
        this.getStoreWalkCaptureType = getStoreWalkCaptureType;
    }

    public UrlConfig getGetSectionApiServices() {
        return getSectionApiServices;
    }

    public void setGetSectionApiServices(UrlConfig getSectionApiServices) {
        this.getSectionApiServices = getSectionApiServices;
    }

    public UrlConfig getGetSectionAttributesApiServices() {
        return getSectionAttributesApiServices;
    }

    public void setGetSectionAttributesApiServices(UrlConfig getSectionAttributesApiServices) {
        this.getSectionAttributesApiServices = getSectionAttributesApiServices;
    }

    public UrlConfig getGetAlertListCodecheckServices() {
        return getAlertListCodecheckServices;
    }

    public void setGetAlertListCodecheckServices(UrlConfig getAlertListCodecheckServices) {
        this.getAlertListCodecheckServices = getAlertListCodecheckServices;
    }

    public UnixServerConfig getUnixUser() {
        return unixUser;
    }

    public void setUnixUser(UnixServerConfig unixUser) {
        this.unixUser = unixUser;
    }

    public WebServiceHeaders getTaskServiceHearders() {
        return taskServiceHearders;
    }

    public void setTaskServiceHearders(WebServiceHeaders taskServiceHearders) {
        this.taskServiceHearders = taskServiceHearders;
    }

    public UrlConfig getCreateWalkitem() {
        return createWalkitem;
    }

    public void setCreateWalkitem(UrlConfig createWalkitem) {
        this.createWalkitem = createWalkitem;
    }

    public UrlConfig getCreateStorewalk() {
        return createStorewalk;
    }

    public void setCreateStorewalk(UrlConfig createStorewalk) {
        this.createStorewalk = createStorewalk;
    }

    public UrlConfig getDeleteStorewalk() {
        return deleteStorewalk;
    }

    public void setDeleteStorewalk(UrlConfig deleteStorewalk) {
        this.deleteStorewalk = deleteStorewalk;
    }

    public UrlConfig getGetWalkitem() {
        return getWalkitem;
    }

    public void setGetWalkitem(UrlConfig getWalkitem) {
        this.getWalkitem = getWalkitem;
    }

    public UrlConfig getGetCaptures() {
        return getCaptures;
    }

    public void setGetCaptures(UrlConfig getCaptures) {
        this.getCaptures = getCaptures;
    }

    public UrlConfig getGetAmendOrders() {
        return getAmendOrders;
    }

    public void setGetAmendOrders(UrlConfig getAmendOrders) {
        this.getAmendOrders = getAmendOrders;
    }

    public UserCredentialsConfig getUserService() {
        return userService;
    }

    public void setUserService(UserCredentialsConfig userService) {
        this.userService = userService;
    }

    public WebServiceeConfig getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(WebServiceeConfig userLogin) {
        this.userLogin = userLogin;
    }

    public UrlConfig getGetMarkdownDetails() {
        return getMarkdownDetails;
    }

    public void setGetMarkdownDetails(UrlConfig getMarkdownDetails) {
        this.getMarkdownDetails = getMarkdownDetails;
    }

    public UrlConfig getGetBlueyonderService() {
        return getBlueyonderService;
    }

    public void setGetBlueyonderService(UrlConfig getBlueyonderService) {
        this.getBlueyonderService = getBlueyonderService;
    }

    public UrlConfig getGetMarkdownList() {
        return getMarkdownList;
    }

    public void setGetMarkdownList(UrlConfig getMarkdownList) {
        this.getMarkdownList = getMarkdownList;
    }

    public CleanAndRotate_TestData getCleanAndRotateTestData() {
        return cleanAndRotateTestData;
    }


    public void setCleanAndRotateTestData(CleanAndRotate_TestData cleanAndRotateTestData) {
        this.cleanAndRotateTestData = cleanAndRotateTestData;
    }

    public UrlConfig getDeletePrintList() {
        return deletePrintList;
    }

    public void setDeletePrintList(UrlConfig deletePrintList) {
        this.deletePrintList = deletePrintList;
    }

    public WebServiceConfig getGetProductDetail() {
        return getProductDetail;
    }

    public void setGetProductDetail(WebServiceConfig getProductDetail) {
        this.getProductDetail = getProductDetail;
    }

    public WebServiceConfig getPostStorewalk() {
        return postStorewalk;
    }

    public void setPostStorewalk(WebServiceConfig postStorewalk) {
        this.postStorewalk = postStorewalk;
    }

    public WebServiceConfig getGetGlhSummary() {
        return getGlhSummary;
    }

    public void setGetGlhSummary(WebServiceConfig getGlhSummary) {
        this.getGlhSummary = getGlhSummary;
    }

    public WebServiceConfig getPostStockTranfer() {
        return postStockTranfer;
    }

    public void setPostStockTranfer(WebServiceConfig postStockTranfer) {
        this.postStockTranfer = postStockTranfer;
    }

    public WebServiceConfig getPostBasketV2() {
        return postBasketV2;
    }

    public void setPostBasketV2(WebServiceConfig postBasketV2) {
        this.postBasketV2 = postBasketV2;
    }

    public WebServiceConfig getPostStockMovement() {
        return postStockMovement;
    }

    public void setPostStockMovement(WebServiceConfig postStockMovement) {
        this.postStockMovement = postStockMovement;
    }

    public WebServiceHeaders getStockMovementServiceHeader() {
        return stockMovementServiceHeader;
    }

    public void setStockMovementServiceHeader(WebServiceHeaders stockMovementServiceHeader) {
        this.stockMovementServiceHeader = stockMovementServiceHeader;
    }

    public WebServiceConfig getGetSpace() {
        return getSpace;
    }

    public void setGetSpace(WebServiceConfig getSpace) {
        this.getSpace = getSpace;
    }

    public WebServiceHeaders getGetSpaceServiceHeader() {
        return getSpaceServiceHeader;
    }

    public void setGetSpaceServiceHeader(WebServiceHeaders getSpaceServiceHeader) {
        this.getSpaceServiceHeader = getSpaceServiceHeader;
    }

    public WebServiceConfig getGetRange() {
        return getRange;
    }

    public void setGetRange(WebServiceConfig getRange) {
        this.getRange = getRange;
    }

    public WebServiceConfig getPostUserLogin() {
        return postUserLogin;
    }

    public void setPostUserLogin(WebServiceConfig postUserLogin) {
        this.postUserLogin = postUserLogin;
    }

    public DatabaseConfig getTestDatabase() {
        return testDatabase;
    }

    public void setTestDatabase(DatabaseConfig testDatabase) {
        this.testDatabase = testDatabase;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "priceDatabase=" + priceDatabase +
                ", testDatabase=" + testDatabase +
                ", spaceDatabase=" + spaceDatabase +
                ", promotionDatabase=" + promotionDatabase +
                ", productDatabase=" + productDatabase +
                ", priceCheckDatabase=" + priceCheckDatabase +
                ", pcaMfsDatabase=" + pcaMfsDatabase +
                ", stockV2Databse=" + stockV2Databse +
                ", wasteValidationDatabse=" + wasteValidationDatabase +
                ", cleanAndRotate=" + cleanAndRotate +
                ", spaceUnixServer=" + spaceUnixServer +
                ", promoPriceUnixServer=" + promoPriceUnixServer +
                ", productUnixServer=" + productUnixServer +
                ", stockv2Unixserver1=" + stockv2Unixserver1 +
                ", stockv2Unixserver2=" + stockv2Unixserver2 +
                ", unixUser=" + unixUser +
                ", proxyConfiguration=" + proxyConfiguration +
                ", actionConfiguration=" + actionConfiguration +
                ", promoServiceHeaders=" + promoServiceHeaders +
                ", bffServiceHeaders=" + bffServiceHeaders +
                ", productServiceHeaders=" + productServiceHeaders +
                ", productSearchServiceHeaders=" + productSearchServiceHeaders +
                ", priceServiceHeaders=" + priceServiceHeaders +
                ", adaptersConfigServiceHeader=" + adaptersConfigServiceHeader +
                ", priceV2ServiceHeaders=" + priceV2ServiceHeaders +
                ", configServiceHeaders=" + configServiceHeaders +
                ", pcspcaServiceHeader=" + pcspcaServiceHeader +
                ", spaceServiceHearders=" + spaceServiceHearders +
                ", signageServiceHeader=" + signageServiceHeader +
                ", priceCheckServiceHeaders=" + priceCheckServiceHeaders +
                ", taskServiceHearders=" + taskServiceHearders +
                ", stockV2ServiceHeaders=" + stockV2ServiceHeaders +
                ", getItem=" + getItem +
                ", getItemEvents=" + getItemEvents +
                ", getItemSearch=" + getItemSearch +
                ", getAdapterConfig=" + getAdapterConfig +
                ", ecsViewService=" + ecsViewService +
                ", ecsLogonService=" + ecsLogonService +
                ", getCurrentPrice=" + getCurrentPrice +
                ", getOnDatePrice=" + getOnDatePrice +
                ", getPriceHistory=" + getPriceHistory +
                ", getPriceChangeDetails=" + getPriceChangeDetails +
                ", getPriceHistoryForBFF=" + getPriceHistoryForBFF +
                ", getPriceOndateNewEndPoint=" + getPriceOndateNewEndPoint +
                ", getPriceNewEndPointWithoutOnDate=" + getPriceNewEndPointWithoutOnDate +
                ", getPriceEvent=" + getPriceEvent +
                ", getPriceWithDate=" + getPriceWithDate +
                ", getstockv2details=" + getstockv2details +
                ", getLogonService=" + getLogonService +
                ", getGetgapLowhigh=" + getGetgapLowhigh +
                ", getPriceAdapterConfig=" + getPriceAdapterConfig +
                ", getPromotion=" + getPromotion +
                ", getOnDatePromotion=" + getOnDatePromotion +
                ", getActivePromotion=" + getActivePromotion +
                ", getPromoEventStore=" + getPromoEventStore +
                ", getPromoEventProduct=" + getPromoEventProduct +
                ", getPromoEventSince=" + getPromoEventSince +
                ", getPromotionHierarchyConfig=" + getPromotionHierarchyConfig +
                ", getSpaceOndateStatus=" + getSpaceOndateStatus +
                ", getSpaceOndateMinStatus=" + getSpaceOndateMinStatus +
                ", getSpaceOnDate=" + getSpaceOnDate +
                ", getSpaceLocation=" + getSpaceLocation +
                ", getSpaceMinOndate=" + getSpaceMinOndate +
                ", getSpaceStoreMinItemStatus=" + getSpaceStoreMinItemStatus +
                ", getSpaceEvent=" + getSpaceEvent +
                ", getBffOndate=" + getBffOndate +
                ", getBffService=" + getBffService +
                ", getBffOndateInvalidQueryParameter=" + getBffOndateInvalidQueryParameter +
                ", getPriceCheckHistoryWithSince=" + getPriceCheckHistoryWithSince +
                ", getPriceCheckHistoryWithUntil=" + getPriceCheckHistoryWithUntil +
                ", getPriceCheckHistoryWithSinceUntil=" + getPriceCheckHistoryWithSinceUntil +
                ", getPriceCheckHistory=" + getPriceCheckHistory +
                ", getPriceCheckPricDayDiff=" + getPriceCheckPricDayDiff +
                ", getDomainRangeDetails=" + getDomainRangeDetails +
                ", stockV2ShellScripts=" + stockV2ShellScripts +
                ", postPricev2Service=" + postPricev2Service +
                ", getConfigService=" + getConfigService +
                ", promoNASLocation=" + promoNASLocation +
                ", priceNASLocation=" + priceNASLocation +
                ", stockNasLocation=" + stockNasLocation +
                ", ecsStyleIdMappingCsv=" + ecsStyleIdMappingCsv +
                ", rmsInputExtract=" + rmsInputExtract +
                ", rmsStockextractforverification=" + rmsStockextractforverification +
                ", webElementEnviroment=" + webElementEnviroment +
                ", userCredentials=" + userCredentials +
                ", userKeys=" + userKeys +
                ", stockInfo=" + stockInfo +
                ", getDelivery=" + getDelivery +
                ", getPrice=" + getPrice +
                ", getProduct=" + getProduct +
                ", postGLH=" + postGLH +
                ", loginServiceMarkdown=" + loginServiceMarkdown +
                ", printServiceMarkdown=" + printServiceMarkdown +
                ", getMarkdownService=" + getMarkdownService +
                ", getgapLowHigh=" + getgapLowHigh +
                ", walkIdDetails=" + walkIdDetails +
                ", CountDetails=" + CountDetails +
                ", deleteCounts=" + deleteCounts +
                ", getSchedules=" + getSchedules +
                ", getDepartments=" + getDepartments +
                ", getListItems=" + getListItems +
                ", getCategoryDepartments=" + getCategoryDepartments +
                ", getForecastOrders=" + getForecastOrders +
                ", getSOItemDetails=" + getSOItemDetails +
                ", getStoreWalks=" + getStoreWalks +
                ", getStoreWalkForStore=" + getStoreWalkForStore +
                ", getStoreWalkForAttributes=" + getStoreWalkForAttributes +
                ", getStoreWalkCaptureType=" + getStoreWalkCaptureType +
                ", getSectionApiServices=" + getSectionApiServices +
                ", getSectionAttributesApiServices=" + getSectionAttributesApiServices +
                ", getAlertListCodecheckServices=" + getAlertListCodecheckServices +
                ", userService=" + userService +
                ", createWalkitem=" + createWalkitem +
                ", createStorewalk=" + createStorewalk +
                ", getallCapture=" + getallCapture +
                ", getStoreWalkitems=" + getStoreWalkitems +
                ", createCapture=" + createCapture +
                ", deleteStorewalk=" + deleteStorewalk +
                ", getWalkitem=" + getWalkitem +
                ", getCaptures=" + getCaptures +
                ", getAmendOrders=" + getAmendOrders +
                ", userLogin=" + userLogin +
                ", getMarkdownDetails=" + getMarkdownDetails +
                ", getMarkdownDetailsBeforeScan=" + getMarkdownDetailsBeforeScan +
                ", getBlueyonderService=" + getBlueyonderService +
                ", getMarkdownList=" + getMarkdownList +
                ", deletePrintList=" + deletePrintList +
                ", cleanAndRotateTestData=" + cleanAndRotateTestData +
                ", getStockAdjustment=" + getStockAdjustment +
                ", stockAdjustmentServiceHeaders=" + stockAdjustmentServiceHeaders +
                ", getRange=" + getRange +
                ", postUserLogin=" + postUserLogin +
                ", getProductDetail=" + getProductDetail +
                ", postStorewalk=" + postStorewalk +
                ", getGlhSummary=" + getGlhSummary +
                ", postStockTranfer=" + postStockTranfer +
                ", postBasketV2=" + postBasketV2 +
                ", postStockMovement=" + postStockMovement +
                ", stockMovementServiceHeader=" + stockMovementServiceHeader +
                ", getSpace=" + getSpace +
                ", getSpaceServiceHeader=" + getSpaceServiceHeader +
                ", postECSAssociateLabel=" + postECSAssociateLabel +
                ", postEselLabelDetails=" + postEselLabelDetails +
                ", postMarkdownEvent=" + postMarkdownEvent +
                ", getSignageLogon=" + getSignageLogon +
                ", postEcsSignsWithoutOnDate=" + postEcsSignsWithoutOnDate +
                ", postEcsSignsWithOnDate=" + postEcsSignsWithOnDate +
                ", postDefaultLabel=" + postDefaultLabel +
                ", postExplicitLabel=" + postExplicitLabel +
                ", getSignId=" + getSignId +
                ", rangeAdapterDatabase=" + rangeAdapterDatabase +
                ", jenkinsDetails=" + jenkinsDetails +
                ", rackspaceDetails=" + rackspaceDetails +
                ", fccadminCredentials=" + fccadminCredentials +
                ", getSpaceStoreStatus=" + getSpaceStoreStatus +
                '}';
    }

}