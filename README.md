# Periplus Cart Test

Automated test for the Periplus shopping cart using Java, Selenium, and TestNG.

## Prerequisites

- Java 17+
- Maven 3.9+
- Google Chrome (latest)

## Project Structure

```
periplus-cart-tests/
├── pom.xml
└── src/
    └── test/
        ├── java/
        │   └── com/periplus/
        │       ├── base/
        │       │   └── BaseTest.java          # WebDriver setup and teardown
        │       ├── pages/
        │       │   ├── LoginPage.java         # Login page actions
        │       │   ├── SearchResultsPage.java # Search and click product
        │       │   ├── ProductPage.java       # Add to cart action
        │       │   └── CartPage.java          # Cart verification and cleanup
        │       └── tests/
        │           └── AddToCartTest.java     # Test scenario
        └── resources/
            ├── config.properties              # Credentials (not committed to git)
            └── testng.xml                     # TestNG suite configuration
```

## Setup

**1. Clone the repository**
```bash
git clone <repository-url>
cd periplus-cart-tests
```

**2. Create `config.properties`**

Create the file at `src/test/resources/config.properties`:
```properties
email=your_email@gmail.com
password=your_password
```

> `config.properties` is listed in `.gitignore` and will never be committed.

**3. Install dependencies**
```bash
mvn install
```

## Running the Test

**Via IntelliJ**

Right click `AddToCartTest.java` → Run `AddToCartTest`

**Via Maven**
```bash
mvn test
```

## Test Scenario

`AddToCartTest` covers TC-CART-001: Add a single product to the cart.

1. Opens Chrome
2. Navigates to https://www.periplus.com
3. Logs in with credentials from `config.properties`
4. Clears the cart to ensure a clean state
5. Searches for "Atomic Habits"
6. Clicks the first search result
7. Adds the product to the cart
8. Navigates to the cart page
9. Asserts the item name and cart badge count