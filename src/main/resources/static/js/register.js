$(document).ready(function () {
   // on ready
});

const registerUser = async () => {
    // check if passwords match
    if ($('#exampleInputPassword').val() !== $('#exampleRepeatPassword').val()) {
        alert('Passwords do not match!');
        return;
    }

    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify({
            id: $('#exampleInputID').val(),
            email: $('#exampleInputEmail').val(),
            password: $('#exampleInputPassword').val(),
            name: $('#exampleFirstName').val(),
            last_name: $('#exampleLastName').val(),
            phone: $('#exampleInputPhone').val(),
        })
    });

    const users = await request.json();

    alert('User registered successfully!');
}