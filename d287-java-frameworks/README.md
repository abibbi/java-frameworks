** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. **

WESTERN GOVERNORS UNIVERSITY  
D287 – JAVA FRAMEWORKS

Spring Boot demo: inventory for **BC Skateboard Shop** (parts and products), Thymeleaf views, and H2 file-backed database (`application.properties`).

---

## Part C  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

| File | Line(s) | Change |
|------|---------|--------|
| `src/main/resources/templates/mainscreen.html` | 14 | Set the document `<title>` to the shop name **BC Skateboard Shop**. |
| `src/main/resources/templates/mainscreen.html` | 16–118 | Added custom CSS (variables, body background, sticky nav, hero and section card styling, table tweaks) to customize the look of the main screen without removing required elements. |
| `src/main/resources/templates/mainscreen.html` | 121–132 | Added a top navigation bar showing the shop name (**BC Skateboard Shop**) with a brand badge and a link to the About page. |
| `src/main/resources/templates/mainscreen.html` | 134–137 | Added a hero block with **BC Skateboard Shop** as the main heading and a subtitle that describes managing skateboard **parts** and **products**. |
| `src/main/resources/templates/mainscreen.html` | 139–172 | Wrapped the **Parts** area in a section card; kept the parts table with column header **Part Name** (line 154) and each row showing the part name via `th:text="${tempPart.name}"` (lines 162–163). |
| `src/main/resources/templates/mainscreen.html` | 174–211 | Wrapped the **Products** area in a section card; kept the products table with column header **Product Name** (line 193) and each row showing the product name via `th:text="${tempProduct.name}"` (lines 201–202). |

---

## Part D  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

| File | Line(s) | Change |
|------|---------|--------|
| `src/main/resources/templates/About.html` | 14 | Set the document `<title>` to **About - BC Skateboard Shop**. |
| `src/main/resources/templates/About.html` | 16–102 | Added page styling (CSS variables, body background, sticky nav, content card) aligned with the main screen look. |
| `src/main/resources/templates/About.html` | 105–113 | Top navigation: **Home** links to `mainscreen.html` (return to main screen); **About us** links to `about.html` (current page). |
| `src/main/resources/templates/About.html` | 115–137 | Main content: heading **Who We Are**, tagline, and paragraphs describing **BC Skateboard Shop** (mission, products, community). |
| `src/main/resources/templates/mainscreen.html` | 127–130 | Top navigation **About us** link to `about.html` so users can open the About page from the main inventory screen. |

---

## Part E  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

| File | Line(s) | Change |
|------|---------|--------|
| `src/main/java/com/example/demo/bootstrap/BootStrapData.java` | 32–36 | `BootStrapData` implements `CommandLineRunner`; constructor injects `PartRepository`, `ProductRepository`, and `OutsourcedPartRepository`. |
| `src/main/java/com/example/demo/bootstrap/BootStrapData.java` | 41–44 | Sample inventory is added only when both part and product repository counts are zero, so existing rows are not overwritten. |
| `src/main/java/com/example/demo/bootstrap/BootStrapData.java` | 47–49 | Comments describe five BC Skateboard Shop parts and using a **4-pack** wheel part because the product–part relation is a `Set` (same part cannot be added twice). |
| `src/main/java/com/example/demo/bootstrap/BootStrapData.java` | 51–94 | Builds five sample parts (in-house and outsourced): name, price, `inv`, `partId` / `companyName` as needed, and **`setMinValue(1)`** / **`setMaxValue(100)`** on each; saves each with `partRepository.save(...)`. |
| `src/main/java/com/example/demo/bootstrap/BootStrapData.java` | 96–163 | Creates five products, adds associated parts via `getParts().add(...)`, syncs `getProducts()` on parts for the many-to-many, then saves products and re-saves updated parts. |
| `src/main/java/com/example/demo/bootstrap/BootStrapData.java` | 167–169 | Logs completion and final part/product counts after startup. |
| `src/main/java/com/example/demo/domain/Part.java` | 29–40 | **`inv`**, **`minValue`**, **`maxValue`**, and **`price`** on **Part** with Bean Validation (`@Min`, `@Max` on `maxValue`) so sample and persisted parts store stock, bounds, and cost. |
| `src/main/java/com/example/demo/domain/Part.java` | 94–108 | **`getMinValue` / `setMinValue`** and **`getMaxValue` / `setMaxValue`** so bootstrap (and the rest of the app) can read and write min/max inventory on each part. |

---

## Parts F–J  Rubric (remaining tasks)

**F.** Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:


Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
• The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.


H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.


I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


J.  Remove the class files for any unused validators in order to clean your code.
