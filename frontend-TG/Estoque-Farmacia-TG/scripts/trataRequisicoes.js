function post(url, requestJSON) {
    $.ajax({
        type: "POST",
        url: url,
        headers: {
            "Content-Type": "application/json"
        },
        data: requestJSON,
        success: function(data) {
            console.log(data);
        },
        error: function(data) {}
    });
}

function put(url, requestJSON) {
    $.ajax({
        type: "PUT",
        url: url,
        headers: {
            "Content-Type": "application/json"
        },
        data: requestJSON,
        success: function(data) {
            console.log(data);
        },
        error: function(data) {}
    });
}


function get(url, requestJSON) {
    $.ajax({
        type: "GET",
        url: url,
        headers: {
            "Content-Type": "application/json"
        },
        data: requestJSON,
        success: function(data) {
            console.log(data);
        },
        error: function(data) {}
    });
}


function del(url, requestJSON) {
    $.ajax({
        type: "DELETE",
        url: url,
        headers: {
            "Content-Type": "application/json"
        },
        data: requestJSON,
        success: function(data) {
            console.log(data);
        },
        error: function(data) {}
    });
}