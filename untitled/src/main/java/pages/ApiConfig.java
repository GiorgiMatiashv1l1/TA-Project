package pages;


public final class ApiConfig {

    private ApiConfig() {}

    // ── Base ──────────────────────────────────────────────────────────────────
    public static final String BASE_URL = "https://automationexercise.com";

    // ── Endpoints ─────────────────────────────────────────────────────────────
    public static final String PRODUCTS_LIST      = "/api/productsList";
    public static final String BRANDS_LIST        = "/api/brandsList";
    public static final String SEARCH_PRODUCT     = "/api/searchProduct";
    public static final String VERIFY_LOGIN       = "/api/verifyLogin";
    public static final String CREATE_ACCOUNT     = "/api/createAccount";
    public static final String DELETE_ACCOUNT     = "/api/deleteAccount";
    public static final String UPDATE_ACCOUNT     = "/api/updateAccount";
    public static final String GET_USER_BY_EMAIL  = "/api/getUserDetailByEmail";

    // ── Response Codes ────────────────────────────────────────────────────────
    public static final int HTTP_OK              = 200;
    public static final int HTTP_METHOD_NOT_ALLOWED = 405;

    // ── API Response Codes (inside JSON body) ─────────────────────────────────
    public static final int API_SUCCESS          = 200;
    public static final int API_NOT_FOUND        = 404;
    public static final int API_METHOD_NOT_ALLOWED = 405;
    public static final int API_BAD_REQUEST      = 400;

    // ── Timeouts (ms) ─────────────────────────────────────────────────────────
    public static final int CONNECTION_TIMEOUT   = 10_000;
    public static final int READ_TIMEOUT         = 15_000;

    // ── Test data ─────────────────────────────────────────────────────────────
    public static final String VALID_EMAIL       = "testuser@example.com";
    public static final String VALID_PASSWORD    = "Test@1234";
    public static final String INVALID_EMAIL     = "notexist@nowhere.com";
    public static final String INVALID_PASSWORD  = "wrongpassword";
}