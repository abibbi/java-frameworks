** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. **

WESTERN GOVERNORS UNIVERSITY
D287 – JAVA FRAMEWORKS


## Part C  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

| File | Line(s) | Change |
|------|---------|--------|
| `src/main/resources/templates/mainscreen.html` | 14 | Set the document `<title>` to the shop name **BC Skateboard Shop**. |
| `src/main/resources/templates/mainscreen.html` | 16–117 | Added custom CSS (variables, body background, sticky nav, hero and section card styling, table tweaks) to customize the look of the main screen without removing required elements. |
| `src/main/resources/templates/mainscreen.html` | 121–132 | Added a top navigation bar showing the shop name (**BC Skateboard Shop**) with a brand badge and a link to the About page. |
| `src/main/resources/templates/mainscreen.html` | 134–137 | Added a hero block with **BC Skateboard Shop** as the main heading and a subtitle that describes managing skateboard **parts** and **products**. |
| `src/main/resources/templates/mainscreen.html` | 139–172 | Wrapped the **Parts** area in a section card; kept the parts table with column header **Part Name** (line 154) and each row showing the part name via `th:text="${tempPart.name}"` (lines 161–162). |
| `src/main/resources/templates/mainscreen.html` | 174–211 | Wrapped the **Products** area in a section card; kept the products table with column header **Product Name** (line 193) and each row showing the product name via `th:text="${tempProduct.name}"` (lines 200–201). |



## Part D  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

| File | Line(s) | Change |
|------|---------|--------|
| `src/main/resources/templates/About.html` | 14 | Set the document `<title>` to **About - BC Skateboard Shop**. |
| `src/main/resources/templates/About.html` | 16–102 | Added page styling (CSS variables, body background, sticky nav, content card) aligned with the main screen look. |
| `src/main/resources/templates/About.html` | 105–114 | Top navigation: **Home** links to `mainscreen.html` (return to main screen); **About us** links to `about.html` (current page). |
| `src/main/resources/templates/About.html` | 116–137 | Main content: heading **Who We Are**, tagline, and paragraphs describing **BC Skateboard Shop** (mission, products, community). |
| `src/main/resources/templates/mainscreen.html` | 127–130 | Top navigation **About us** link to `about.html` so users can open the About page from the main inventory screen. |



## Part E  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

| File | Line(s) | Change |
|------|---------|--------|
| `src/main/resources/templates/mainscreen.html` | 14 | Set the document `<title>` to the shop name **BC Skateboard Shop**. |
| `src/main/resources/templates/mainscreen.html` | 16–118 | Added custom CSS (variables, body background, sticky nav, hero and section card styling, table tweaks) to customize the look of the main screen without removing required elements. |
| `src/main/resources/templates/mainscreen.html` | 121–132 | Added a top navigation bar showing the shop name (**BC Skateboard Shop**) with a brand badge and a link to the About page. |
| `src/main/resources/templates/mainscreen.html` | 134–137 | Added a hero block with **BC Skateboard Shop** as the main heading and a subtitle that describes managing skateboard **parts** and **products**. |
| `src/main/resources/templates/mainscreen.html` | 139–172 | Wrapped the **Parts** area in a section card; kept the parts table with column header **Part Name** (line 154) and each row showing the part name via `th:text="${tempPart.name}"` (lines 162–163). |
| `src/main/resources/templates/mainscreen.html` | 174–211 | Wrapped the **Products** area in a section card; kept the products table with column header **Product Name** (line 193) and each row showing the product name via `th:text="${tempProduct.name}"` (lines 20
---




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
