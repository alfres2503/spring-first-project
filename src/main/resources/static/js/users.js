// Call the dataTables jQuery plugin
$(document).ready(function () {
    loadUsers();
    $('#users').DataTable();

});

async function loadUsers() {
    const request = await fetch("api/users", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const users = await request.json();

    for (let user of users) {
        let deleteButton = "<a href=\"#\" onclick='deleteUser("+ user.id +")' class=\"btn btn-danger btn-circle\">\n"

        let userHtml = "<tr>\n" +
            "                                            <td>"+ user.id +"</td>\n" +
            "                                            <td>"+ (user.name + " " + user.last_name) +"</td>\n" +
            "                                            <td>"+ user.email +"</td>\n" +
            "                                            <td>"+ user.phone +"</td>\n" +
            "                                            <td>\n" + deleteButton +
            "                                                    <i class=\"fas fa-trash\"></i>\n" +
            "                                                </a>\n" +
            "                                            </td>\n" +
            "</tr>";

        $("#users tbody").append(userHtml);
    }
}

const deleteUser = async (id) => {
    if (!confirm("Do you want to delete this user?"))
        return;

    const request = await fetch(`api/users/${id}`, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    // remove the row from the table
    $(`#users tbody tr td:contains(${id})`).parent().remove();
}