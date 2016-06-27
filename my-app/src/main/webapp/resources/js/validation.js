$(document).ready(function () {
    $("#datepicker").datepicker({dateFormat: 'dd.mm.yy'});

    $("#studentForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 1,
                maxlength: 60
            },
            surname: {
                required: true,
                minlength: 1,
                maxlength: 60
            },
            birthday: {
                required: true,
                dateInThePast: true
            }
        },
        messages: {
            name: {
                required: "Name is required!",
                minlength: "Name must be at least 1 characters long.",
                maxlength: "Name cannot be longer than 60 characters."
            },
            surname: {
                required: "Surname is required!",
                minlength: "Surname must be at least 1 characters long.",
                maxlength: "Surname cannot be longer than 60 characters."
            },
            birthday: {
                required: "Birthday is required!",
                dateInThePast: "Your birthday cannot be a future date."
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });

});

