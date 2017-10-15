// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = this.customers.partition {
    val unfilledOrders = it.orders.filter { !it.isDelivered }.size
    val filledOrders = it.orders.filter { it.isDelivered }.size
    filledOrders < unfilledOrders
}.first.toSet()
