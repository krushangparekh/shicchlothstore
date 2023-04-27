package com.example.ClothsStore.userModel

import java.util.ArrayList

internal class ClientDetails {
    var acceptLanguage: String? = null
    var browserHeight: Any? = null
    var browserIp: String? = null
    var browserWidth: Any? = null
    var sessionHash: Any? = null
    var userAgent: String? = null
}

internal class CurrentSubtotalPriceSet {
    var shopMoney: ShopMoney? = null
    var presentmentMoney: PresentmentMoney? = null
}

internal class CurrentTotalDiscountsSet {
    var shopMoney: ShopMoney_? = null
    var presentmentMoney: PresentmentMoney_? = null
}

internal class CurrentTotalPriceSet {
    var shopMoney: ShopMoney__? = null
    var presentmentMoney: PresentmentMoney__? = null
}

internal class CurrentTotalTaxSet {
    var shopMoney: ShopMoney___? = null
    var presentmentMoney: PresentmentMoney___? = null
}

internal class Customer {
    var id: Int? = null
    var email: String? = null
    var acceptsMarketing: Boolean? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var state: String? = null
    var note: Any? = null
    var verifiedEmail: Boolean? = null
    var multipassIdentifier: Any? = null
    var taxExempt: Boolean? = null
    var phone: Any? = null
    var emailMarketingConsent: EmailMarketingConsent? = null
    var smsMarketingConsent: Any? = null
    var tags: String? = null
    var currency: String? = null
    var acceptsMarketingUpdatedAt: String? = null
    var marketingOptInLevel: Any? = null
    var taxExemptions: List<Any> = ArrayList()
    var adminGraphqlApiId: String? = null
    var defaultAddress: DefaultAddress? = null
}

internal class Datum {
    var id: Int? = null
    var adminGraphqlApiId: String? = null
    var appId: Int? = null
    var browserIp: String? = null
    var buyerAcceptsMarketing: Boolean? = null
    var cancelReason: Any? = null
    var cancelledAt: Any? = null
    var cartToken: String? = null
    var checkoutId: Int? = null
    var checkoutToken: String? = null
    var clientDetails: ClientDetails? = null
    var closedAt: Any? = null
    var company: Any? = null
    var confirmed: Boolean? = null
    var contactEmail: String? = null
    var createdAt: String? = null
    var currency: String? = null
    var currentSubtotalPrice: String? = null
    var currentSubtotalPriceSet: CurrentSubtotalPriceSet? = null
    var currentTotalDiscounts: String? = null
    var currentTotalDiscountsSet: CurrentTotalDiscountsSet? = null
    var currentTotalDutiesSet: Any? = null
    var currentTotalPrice: String? = null
    var currentTotalPriceSet: CurrentTotalPriceSet? = null
    var currentTotalTax: String? = null
    var currentTotalTaxSet: CurrentTotalTaxSet? = null
    var customerLocale: String? = null
    var deviceId: Any? = null
    var discountCodes: List<Any> = ArrayList()
    var email: String? = null
    var estimatedTaxes: Boolean? = null
    var financialStatus: String? = null
    var fulfillmentStatus: Any? = null
    var gateway: String? = null
    var landingSite: String? = null
    var landingSiteRef: Any? = null
    var locationId: Any? = null
    var merchantOfRecordAppId: Any? = null
    var name: String? = null
    var note: Any? = null
    var noteAttributes: List<Any> = ArrayList()
    var number: Int? = null
    var orderNumber: Int? = null
    var orderStatusUrl: String? = null
    var originalTotalDutiesSet: Any? = null
    var paymentGatewayNames: List<String> = ArrayList()
    var phone: Any? = null
    var presentmentCurrency: String? = null
    var processedAt: String? = null
    var processingMethod: String? = null
    var reference: String? = null
    var referringSite: String? = null
    var sourceIdentifier: String? = null
    var sourceName: String? = null
    var sourceUrl: Any? = null
    var subtotalPrice: String? = null
    var subtotalPriceSet: SubtotalPriceSet? = null
    var tags: String? = null
    var taxLines: List<TaxLine> = ArrayList()
    var taxesIncluded: Boolean? = null
    var test: Boolean? = null
    var token: String? = null
    var totalDiscounts: String? = null
    var totalDiscountsSet: TotalDiscountsSet? = null
    var totalLineItemsPrice: String? = null
    var totalLineItemsPriceSet: TotalLineItemsPriceSet? = null
    var totalOutstanding: String? = null
    var totalPrice: String? = null
    var totalPriceSet: TotalPriceSet? = null
    var totalShippingPriceSet: TotalShippingPriceSet? = null
    var totalTax: String? = null
    var totalTaxSet: TotalTaxSet? = null
    var totalTipReceived: String? = null
    var totalWeight: Int? = null
    var updatedAt: String? = null
    var userId: Any? = null
    var customer: Customer? = null
    var discountApplications: List<Any> = ArrayList()
    var fulfillments: List<Any> = ArrayList()
    var lineItems: List<LineItem> = ArrayList()
    var paymentTerms: Any? = null
    var refunds: List<Any> = ArrayList()
    var shippingAddress: ShippingAddress? = null
    var shippingLines: List<ShippingLine> = ArrayList()
}

internal class DefaultAddress {
    var id: Int? = null
    var customerId: Int? = null
    var firstName: String? = null
    var lastName: String? = null
    var company: Any? = null
    var address1: String? = null
    var address2: Any? = null
    var city: String? = null
    var province: String? = null
    var country: String? = null
    var zip: String? = null
    var phone: Any? = null
    var name: String? = null
    var provinceCode: String? = null
    var countryCode: String? = null
    var countryName: String? = null
    var default: Boolean? = null
}

internal class DiscountedPriceSet {
    var shopMoney: ShopMoney______________? = null
    var presentmentMoney: PresentmentMoney______________? = null
}

internal class EmailMarketingConsent {
    var state: String? = null
    var optInLevel: String? = null
    var consentUpdatedAt: Any? = null
}

internal class LineItem {
    var id: Int? = null
    var adminGraphqlApiId: String? = null
    var fulfillableQuantity: Int? = null
    var fulfillmentService: String? = null
    var fulfillmentStatus: Any? = null
    var giftCard: Boolean? = null
    var grams: Int? = null
    var name: String? = null
    var price: String? = null
    var priceSet: PriceSet_? = null
    var productExists: Boolean? = null
    var productId: Int? = null
    var properties: List<Any> = ArrayList()
    var quantity: Int? = null
    var requiresShipping: Boolean? = null
    var sku: String? = null
    var taxable: Boolean? = null
    var title: String? = null
    var totalDiscount: String? = null
    var totalDiscountSet: TotalDiscountSet? = null
    var variantId: Int? = null
    var variantInventoryManagement: String? = null
    var variantTitle: String? = null
    var vendor: String? = null
    var taxLines: List<TaxLine_> = ArrayList()
    var duties: List<Any> = ArrayList()
    var discountAllocations: List<Any> = ArrayList()
}

internal class PresentmentMoney {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney_ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney__ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney___ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney____ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney_____ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney______ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney_______ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney_________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney__________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney___________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney____________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney_____________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney______________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PresentmentMoney_______________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class PriceSet {
    var shopMoney: ShopMoney_____? = null
    var presentmentMoney: PresentmentMoney_____? = null
}

internal class PriceSet_ {
    var shopMoney: ShopMoney___________? = null
    var presentmentMoney: PresentmentMoney___________? = null
}

internal class PriceSet__ {
    var shopMoney: ShopMoney_____________? = null
    var presentmentMoney: PresentmentMoney_____________? = null
}

internal class PriceSet___ {
    var shopMoney: ShopMoney_______________? = null
    var presentmentMoney: PresentmentMoney_______________? = null
}

internal class Root {
    var status: Int? = null
    var message: String? = null
    var data: List<Datum> = ArrayList()
}

internal class ShippingAddress {
    var firstName: String? = null
    var address1: String? = null
    var phone: Any? = null
    var city: String? = null
    var zip: String? = null
    var province: String? = null
    var country: String? = null
    var lastName: String? = null
    var address2: Any? = null
    var company: Any? = null
    var latitude: Double? = null
    var longitude: Double? = null
    var name: String? = null
    var countryCode: String? = null
    var provinceCode: String? = null
}

internal class ShippingLine {
    var id: Int? = null
    var carrierIdentifier: String? = null
    var code: String? = null
    var deliveryCategory: Any? = null
    var discountedPrice: String? = null
    var discountedPriceSet: DiscountedPriceSet? = null
    var phone: Any? = null
    var price: String? = null
    var priceSet: PriceSet___? = null
    var requestedFulfillmentServiceId: Any? = null
    var source: String? = null
    var title: String? = null
    var taxLines: List<Any> = ArrayList()
    var discountAllocations: List<Any> = ArrayList()
}

internal class ShopMoney {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney_ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney__ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney___ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney____ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney_____ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney______ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney_______ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney_________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney__________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney___________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney____________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney_____________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney______________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class ShopMoney_______________ {
    var amount: String? = null
    var currencyCode: String? = null
}

internal class SubtotalPriceSet {
    var shopMoney: ShopMoney____? = null
    var presentmentMoney: PresentmentMoney____? = null
}

internal class TaxLine {
    var price: String? = null
    var rate: Double? = null
    var title: String? = null
    var priceSet: PriceSet? = null
    var channelLiable: Boolean? = null
}

internal class TaxLine_ {
    var channelLiable: Boolean? = null
    var price: String? = null
    var priceSet: PriceSet__? = null
    var rate: Double? = null
    var title: String? = null
}

internal class TotalDiscountSet {
    var shopMoney: ShopMoney____________? = null
    var presentmentMoney: PresentmentMoney____________? = null
}

internal class TotalDiscountsSet {
    var shopMoney: ShopMoney______? = null
    var presentmentMoney: PresentmentMoney______? = null
}

internal class TotalLineItemsPriceSet {
    var shopMoney: ShopMoney_______? = null
    var presentmentMoney: PresentmentMoney_______? = null
}

internal class TotalPriceSet {
    var shopMoney: ShopMoney________? = null
    var presentmentMoney: PresentmentMoney________? = null
}

internal class TotalShippingPriceSet {
    var shopMoney: ShopMoney_________? = null
    var presentmentMoney: PresentmentMoney_________? = null
}

internal class TotalTaxSet {
    var shopMoney: ShopMoney__________? = null
    var presentmentMoney: PresentmentMoney__________? = null
}