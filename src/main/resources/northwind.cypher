USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/categories.csv" AS row
CREATE (:Category {name: row.categoryName, description: row.description, categoryId: row.categoryID});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/products.csv" AS row
CREATE (:Product {name: row.productName, productId: row.productID});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/products.csv" AS row
MATCH (product:Product {productId: row.productID})
MATCH (category:Category {categoryId: row.categoryID})
MERGE (product)-[:IS_IN]->(category);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/employees.csv" AS row
CREATE (:Employee {name: row.firstName, employeeId: row.employeeID});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/employees.csv" AS row
MATCH (employee:Employee {employeeId: row.employeeID})
MATCH (boss:Employee {employeeId: row.reportsTo})
MERGE (employee)-[:REPORTS_TO]->(boss);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/orders.csv" AS row
CREATE (:Order {date: row.shippedDate, orderId: row.orderID});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/order_details.csv" AS row
MATCH (order:Order {orderId: row.orderID})
MATCH (product:Product {productId: row.productID})
MERGE (order)-[:INCLUDES {amount: row.quantity}]->(product);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/orders.csv" AS row
MATCH (order:Order {orderId: row.orderID})
MATCH (employee:Employee {employeeId: row.employeeID})
MERGE (employee)-[:SOLD]->(order);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/customers.csv" AS row
CREATE (:Customer {name: row.companyName, customerId: row.customerID});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/orders.csv" AS row
MATCH (order:Order {orderId: row.orderID})
MATCH (customer:Customer {customerId: row.customerID})
MERGE (customer)-[:BOUGHT]->(order);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/shippers.csv" AS row
CREATE (:Shipper {name: row.companyName, shipperId: row.shipperID});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/orders.csv" AS row
MATCH (order:Order {orderId: row.orderID})
MATCH (shipper:Shipper {shipperId: row.shipVia})
MERGE (shipper)-[:SHIPPED]->(order);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/suppliers.csv" AS row
CREATE (:Supplier {name: row.companyName, supplierId: row.supplierID});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/northwind/csv/products.csv" AS row
MATCH (product:Product {productId: row.productID})
MATCH (supplier:Supplier {supplierId: row.supplierID})
MERGE (supplier)-[:SUPPLIES]->(product);

match (n:Supplier) remove n.supplierId
match (n:Employee) remove n.employeeId
match (n:Customer) remove n.customerId
match (n:Category) remove n.categoryId
match (n:Shipper) remove n.shipperId
match (n:Product) remove n.productId
match (n:Order) remove n.orderId

MATCH (n:Customer) WHERE ID(n) = { id } WITH n
RETURN n,[ [ (n)-[r_b1:BOUGHT]->(o1:Order) |
         [ r_b1, o1, [ [ (o1)-[r_i2:INCLUDES]->(p2:Product) | [ r_i2, p2 ] ] ] ] ] ]
