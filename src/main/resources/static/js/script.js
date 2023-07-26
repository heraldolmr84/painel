//Função para formatar 1 em 01
const zeroFill = n => {
    return ('0' + n ).slice(-2);
}

//criar o intervalo
const interval = setInterval(() => {

    const now = new Date();

    const dataHora = zeroFill(now.getUTCDate()) + '/' + zeroFill((now.getMonth() + 1)) + '/' + now.getFullYear() + ' ' + zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes()) + ':' + zeroFill(now.getSeconds());

    const options = {
        timeZone: 'America/Campo_Grande',
        hour: 'numeric',
        minute: 'numeric'
    };

    //dataHora = new Intl.DateTimeFormat([], options);

    document.getElementById('data-hora').innerHTML = dataHora;
})

//chamar no painel
const frases = document.querySelectorAll(".frase");

frases.map((el) => {
    el.addEventListener("click", (evt) => {

        const vFrase = evt.target;

        console.log(vFrase)
    });
});
