function validateItemNumberValue(value) {
    if (value != "") {

        if (isNumeric(value) == false) {
            alert("Enter only numbers.");
            return false;
        } else return true;
    } else {
        alert("empty field.");
        return false;
    }
}

function validateItemVarchar(value) {

    if (value != "") {
        if (isNumeric(value) == true) {
            alert("Enter only Varchar.");
            return false;
        } else return true;
    } else {
        alert("empty field.");
        return false;
    }
}

function isNumeric(val) {
    let regNumeric = "^[0-9]*$";

    if (val.match(regNumeric))
        return true;
    else
        return false;

}