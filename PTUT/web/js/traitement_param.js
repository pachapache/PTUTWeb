$(document).ready(function () {
    $("#mdpInvalide").hide();
    $("#adrInvalide").hide();

    var form = document.getElementById("formulaire");
    form.addEventListener("focus", function (event) {
        var mdp1 = $("#mdp").val();
        var mdp2 = $("#newMdp").val();
        var adr1 = $("#mail").val();
        var adr2 = $("#newMail").val();

        if (mdp1 === mdp2 && (mdp1 !== "" || mdp2 !== "")) {
            $("#mdpInvalide").hide();
        }
        if (mdp1 !== mdp2 && (mdp1 !== "" || mdp2 !== "") && (mdp1 !== "" && mdp2 !== "")) {
            $("#mdpInvalide").show("slow");
        }
        if (adr1 === adr2 && (adr1 !== "" || adr2 !== "")) {
            $("#adrInvalide").hide();
        }
        if (adr1 !== adr2 && (adr1 !== "" || adr2 !== "") && (adr1 !== "" && adr2 !== "")) {
            $("#adrInvalide").show("slow");
        }
    }, true);//fin de la vérification de l'identité des mdp adr

})//fin du document js

