package com.backbase.ct.bbfuel.data;

public final class CommonConstants {

    private CommonConstants() {
    }

    // Environment
    public static final String PROPERTIES_FILE_NAME = "data.properties";
    public static final String ENVIRONMENT_PROPERTIES_FILE_NAME = "environment.properties";
    public static final String PROPERTY_HEALTH_CHECK_TIMEOUT_IN_MINUTES = "healthcheck.timeout.in.minutes";
    public static final String PROPERTY_LOG_ALL_REQUESTS_RESPONSES = "log.all.requests.responses";
    public static final String PROPERTY_MULTI_TENANCY_ENVIRONMENT = "multi.tenancy.environment";
    public static final String PROPERTY_TENANT_ID = "tenant.id";

    // Users
    public static final String PROPERTY_ROOT_ENTITLEMENTS_ADMIN = "root.entitlements.admin";
    public static final String PROPERTY_LEGAL_ENTITIES_WITH_USERS_JSON = "legal.entities.with.users.json";
    public static final String PROPERTY_SERVICE_AGREEMENTS_JSON = "service.agreements.json";

    // Entitlements
    static final String EXTERNAL_LEGAL_ENTITY_ID_PREFIX = "C00000";
    public static final String EXTERNAL_ROOT_LEGAL_ENTITY_ID = EXTERNAL_LEGAL_ENTITY_ID_PREFIX + "0";
    public static final String SEPA_CT_FUNCTION_NAME = "SEPA CT";
    public static final String ACH_DEBIT_FUNCTION_NAME = "ACH Debit";
    public static final String US_DOMESTIC_WIRE_FUNCTION_NAME = "US Domestic Wire";
    public static final String US_FOREIGN_WIRE_FUNCTION_NAME = "US Foreign Wire";
    public static final String PAYMENTS_RESOURCE_NAME = "Payments";
    public static final String CONTACTS_RESOURCE_NAME = "Contacts";
    public static final String NOTIFICATIONS_RESOURCE_NAME = "Notifications";
    public static final String CONTACTS_FUNCTION_NAME = CONTACTS_RESOURCE_NAME;
    public static final String NOTIFICATIONS_FUNCTION_NAME = "Manage Notifications";
    public static final String BATCH_RESOURCE_NAME = "Batch";
    public static final String BATCH_SEPA_CT_FUNCTION_NAME = "Batch - SEPA CT";
    public static final String PRIVILEGE_CREATE = "create";
    public static final String PROPERTY_INGEST_ACCESS_CONTROL = "ingest.access.control";
    public static final String PROPERTY_INGEST_CUSTOM_SERVICE_AGREEMENTS = "ingest.custom.service.agreements";
    public static final String PROPERTY_JOB_PROFILES_JSON_LOCATION = "job.profiles.json";
    public static final String PROPERTY_PRODUCT_GROUP_SEED_JSON_LOCATION = "product.group.seed.json";

    // User data
    public static final String PROPERTY_CONTACT_ACCOUNTS_MIN = "contact.accounts.min";
    public static final String PROPERTY_CONTACT_ACCOUNTS_MAX = "contact.accounts.max";
    public static final String PROPERTY_INGEST_BALANCE_HISTORY = "ingest.balance.history";
    public static final String PROPERTY_TRANSACTIONS_MIN = "transactions.min";
    public static final String PROPERTY_TRANSACTIONS_MAX = "transactions.max";
    public static final String PROPERTY_INGEST_TRANSACTIONS = "ingest.transactions";
    public static final String PROPERTY_USE_PFM_CATEGORIES_FOR_TRANSACTIONS = "use.pfm.categories.for.transactions";
    public static final String PROPERTY_NOTIFICATIONS_MIN = "notifications.min";
    public static final String PROPERTY_NOTIFICATIONS_MAX = "notifications.max";
    public static final String PROPERTY_INGEST_NOTIFICATIONS = "ingest.notifications";
    public static final String PROPERTY_INGEST_APPROVALS_FOR_PAYMENTS = "ingest.approvals.for.payments";
    public static final String PROPERTY_INGEST_APPROVALS_FOR_CONTACTS = "ingest.approvals.for.contacts";
    public static final String PROPERTY_INGEST_APPROVALS_FOR_NOTIFICATIONS = "ingest.approvals.for.notifications";
    public static final String PROPERTY_INGEST_APPROVALS_FOR_BATCHES = "ingest.approvals.for.batches";
    public static final String PROPERTY_INGEST_LIMITS = "ingest.limits";
    public static final String PROPERTY_CONTACTS_MIN = "contacts.min";
    public static final String PROPERTY_CONTACTS_MAX = "contacts.max";
    public static final String PROPERTY_INGEST_CONTACTS = "ingest.contacts";
    public static final String PROPERTY_PAYMENTS_MIN = "payments.min";
    public static final String PROPERTY_PAYMENTS_MAX = "payments.max";
    public static final String PROPERTY_INGEST_PAYMENTS = "ingest.payments";
    public static final String PROPERTY_MESSAGES_MIN = "messages.min";
    public static final String PROPERTY_MESSAGES_MAX = "messages.max";
    public static final String PROPERTY_MESSAGE_TOPICS_MIN = "topics.message.min";
    public static final String PROPERTY_MESSAGE_TOPICS_MAX = "topics.message.max";
    public static final String PROPERTY_INGEST_MESSAGES = "ingest.messages";
    public static final String PROPERTY_ACTIONS_MIN = "actions.min";
    public static final String PROPERTY_ACTIONS_MAX = "actions.max";
    public static final String PROPERTY_INGEST_ACTIONS = "ingest.actions";
    public static final String PROPERTY_INGEST_BILLPAY = "ingest.billpay";

    // Product summary
    public static final String PROPERTY_PRODUCTS_JSON_LOCATION = "products.json";

    // Payments
    public static final String PAYMENT_TYPE_SEPA_CREDIT_TRANSFER = "SEPA_CREDIT_TRANSFER";
    public static final String PAYMENT_TYPE_US_DOMESTIC_WIRE = "US_DOMESTIC_WIRE";
    public static final String PAYMENT_TYPE_US_FOREIGN_WIRE = "US_FOREIGN_WIRE";
    public static final String PAYMENT_TYPE_ACH_DEBIT = "ACH_DEBIT";
}
