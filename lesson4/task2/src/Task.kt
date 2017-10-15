class LazyProperty(val initializer: () -> Int) {
    var storedValue: Int? = null

    val lazy: Int
        get() {
            if (storedValue == null) {
                storedValue = initializer()
            }

            return storedValue !!
        }
}
