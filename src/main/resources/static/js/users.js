// Call the dataTables jQuery plugin
$(document).ready(function () {
    loadUsers();
    $('#users').DataTable();
});

async function loadUsers() {
    const request = await fetch("users", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const users = await request.json();

    console.log(users)

    for (let user of users) {
        let userHtml = "<tr>\n" +
            "                                            <td>"+ user.id +"</td>\n" +
            "                                            <td>"+ (user.name + " " + user.last_name) +"</td>\n" +
            "                                            <td>"+ user.email +"</td>\n" +
            "                                            <td>"+ user.phone +"</td>\n" +
            "                                            <td>\n" +
            "                                                <a href=\"#\" class=\"btn btn-danger btn-circle\">\n" +
            "                                                    <i class=\"fas fa-trash\"></i>\n" +
            "                                                </a>\n" +
            "                                            </td>\n" +
            "</tr>";

        $("#users tbody").append(userHtml);
    }


}