// Return all products this customer has ordered
fun Customer.getOrderedProducts(): Set<Product> = this.orders.flatMap { it.products }.toSet()

// Return all products that were ordered by at least one customer
fun Shop.getAllOrderedProducts(): Set<Product> = this.customers.flatMap { it.getOrderedProducts() }.toSet()

// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    return this.customers.fold(this.getAllOrderedProducts(), {
        allSharedProducts: Set<Product>, customer: Customer ->

        allSharedProducts intersect customer.getOrderedProducts()
    })
}
