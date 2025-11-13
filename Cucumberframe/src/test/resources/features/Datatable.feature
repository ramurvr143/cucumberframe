Feature: How to use data table

Scenario: Product details
  Given  I have product information 2 columns asmap:
    | name  | wireless mouse |
    | price | 25.99          |
    | Brand | Logitech       | 
 When I have product information in single column aslist:
 	| Laptop |
 	| Mouse |
 	| Charger |
 And You get a list of lists, where each inner list is one row :
 	| Laptop | 200$ | Lenova |
 	| Mouse | 10$ | Dell |
 	| Charger | 50$ | Lenova |
 Then For multi-row key–value pairs (when the first row contains headers):
 	| name           | price | brand    |
    | wireless mouse | 25.99 | Logitech |
    | keyboard       | 45.50 | Dell     |
    | usb cable      | 9.99  | Amazon   |
  
  
  
  
  
  
  
  