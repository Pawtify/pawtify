var cat = $('.cat').attr('disabled', false);
var dog = $('.dog').attr('disabled', false);
$(cat).change(function() {
    if (cat.val() != "") {
        dog.attr('disabled', true);
    }if (cat.val() == "") {
        dog.attr('disabled', false);
    }
});

$(dog).change(function() {
    if (dog.val() != "") {
        cat.attr('disabled', true);
    }if (dog.val() == "") {
        cat.attr('disabled', false);
    }
});


var vid = document.getElementById("myVideo");
vid.load();
vid.autoplay = true;
vid.loop = true;


