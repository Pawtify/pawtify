// $(document).ready(function() {

    var curr = $('.cat').prop('disabled', false);
    var next = $('.dog').prop('disabled', false);
    $(curr, next).change(function () {
            if (curr != null) {
                next.prop('disabled', true);
            } else if (next != null) {
                curr.disabled = true;
            }
        }
    );

// });
var vid = document.getElementById("myVideo");
vid.load();
vid.autoplay = true;
vid.loop = true;


