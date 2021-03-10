function callApi(btn_id) {

    $("#items_table").on('click', '#' + btn_id, function () {

        let url = "";
        let currentRow = $(this).closest("tr");

        let sell_item_qty = currentRow.find("td:eq(4) input[type='text']").val();
        let sell_item_id = currentRow.find("#itemId").val();

        switch (btn_id) {
            case "sellItemBtn":
                url = $('#sellItemBtn').attr('datasrc');
                break;
            case"deleteItemBtn":
                url = $('#deleteItemBtn').attr('datasrc');
                break;
            case "editItemBtn":
                loadItemById(sell_item_id);
                break;
            default:
                console.log("default block");
                break;
        }
        if (url !== "") {
            let data = JSON.stringify({
                sellItemQuantity: sell_item_qty,
                id: sell_item_id
            });

            let xhttp = new XMLHttpRequest();
            xhttp.open("POST", "http://localhost:8080/grocery/" + url, true);
            xhttp.setRequestHeader("Content-type", "application/json");
            xhttp.send(data);

            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {

                    location.reload(function () {
                        $("#sellItemQuantity").val('');
                    });
                }
            };
        }
    });
}

function saveItem() {

    let saveOrUpdateUrl = "";

    let item_id = $("#itemIdSave").val();
    let item_name = $("#itemNameSave").val();
    let item_qty = $("#itemQuantitySave").val();
    let item_price = $("#itemPriceSave").val();

    let data = JSON.stringify({
        itemName: item_name,
        itemQuantity: item_qty,
        itemPrice: item_price
    });

    let xhttp = new XMLHttpRequest();

    if (item_id === "") {
        saveOrUpdateUrl = "save";
    } else {
        saveOrUpdateUrl = "update";
    }

    if (saveOrUpdateUrl === "") {
        xhttp.open("POST", "http://localhost:8080/grocery/" + saveOrUpdateUrl, true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send(data);

        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                location.reload();
                clearTextField();
            }
        };
    }
}

function loadItemById(item_id) {

    let data = JSON.stringify({
        id: item_id
    });

    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/grocery/loadSingleItem", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(data);

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let itemObj = JSON.parse(this.response);

            let itemId = itemObj["id"];
            let itemName = itemObj["itemName"];
            let itemQuantity = itemObj["itemQuantity"];
            let itemPrice = itemObj["itemPrice"];

            $("#itemIdSave").val(itemId);
            $("#itemNameSave").val(itemName);
            $("#itemNameSave").val(itemName);
            $("#itemQuantitySave").val(itemQuantity);
            $("#itemPriceSave").val(itemPrice);

            $('#exampleModalCenter').modal('show');
        }
    };
}

function clearTextField() {
    $("#itemIdSave").val("");
    $("#itemNameSave").val("");
    $("#itemNameSave").val("");
    $("#itemQuantitySave").val("");
    $("#itemPriceSave").val("");
}