<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Items</title>
    <link href="webjars/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .margin {
            margin: 10px;
        }

        .no-border {
            border: 0;
            box-shadow: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row ">
        <div class="col-md">
            <h2 class="text-center">Grocery Admin view</h2>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#exampleModalCenter">Add
            new Item
        </button>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md">

            <table class="table" id="items_table">
                <thead>
                <tr>
                    <th scope="col">Item Name</th>
                    <th scope="col">Available Quantity</th>
                    <th scope="col">One Item Price</th>
                    <th scope="col">All Item Price</th>
                    <th scope="col">Sell Item Qty</th>
                    <th scope="col">Sell Item</th>
                    <th scope="col">Remove Item</th>
                    <th scope="col">Edit Item</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ItemCollection}" var="GroceryItems">

                    <tr>
                        <td>
                            <input type="text" class="no-border form-control shadow-none" id="itemName"
                                   value=" ${GroceryItems.itemName}"/>
                        </td>
                        <td>
                            <input type="text" class="no-border form-control shadow-none" readonly id="itemQuantity"
                                   name="itemQuantity"
                                   value=" ${GroceryItems.itemQuantity}"/>
                        </td>
                        <td>
                            <input type="text" class="no-border form-control shadow-none" readonly name="itemPrice"
                                   id="itemPrice"
                                   value=" ${GroceryItems.itemPrice}"/>
                        </td>
                        <td>
                            <input type="text" class="no-border form-control shadow-none" readonly id="itemLotPrice"
                                   name="itemLotPrice"
                                   value=" ${GroceryItems.itemLotPrice}"/>
                        </td>
                        <td>
                            <input type="text" class="form-control-plaintext" id="sellItemQuantity"
                                   name="sellItemQuantity"/>
                            <input type="number" hidden id="itemId" value="${GroceryItems.id}"/>
                        </td>
                        <td>
                            <button type="button" class="btn btn-success" datasrc="sell"
                                    id="sellItemBtn" onclick="callApi(this.id)">Sell
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger" datasrc="delete" id="deleteItemBtn"
                                    onclick="callApi(this.id)">Delete
                            </button>
                        </td>
                        <td>
                            <button class="btn btn-primary" datasrc="edit" id="editItemBtn" onclick="callApi(this.id)">
                                Edit
                            </button>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <div class="row">
        <div class="col-md">
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Add new Grocery Items/Edit Grocery Items</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group row">
                                <div class="col-md">
                                    <div class="row margin">
                                        <div class="col-md-6 text-justify">
                                            <label for="itemName">Item Name : </label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control-plaintext" id="itemNameSave"
                                                   name="itemName" required="Item name is empty">
                                        </div>
                                    </div>
                                    <div class="row margin">
                                        <div class="col-md-6 text-justify">
                                            <label for="itemQuantity">Item Quantity : </label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control-plaintext" id="itemQuantitySave"
                                                   name="itemQuantity" required="Item quantity is empty">
                                        </div>
                                    </div>
                                    <div class="row margin">
                                        <div class="col-md-6 text-justify">
                                            <label for="itemPrice">Single Item Price : </label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control-plaintext" id="itemPriceSave"
                                                   name="itemPrice" required="Single item price is empty">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" onclick="saveItem()">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="js/util.js"></script>


