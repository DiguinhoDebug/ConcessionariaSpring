const url = "http://localhost:8080/concessionaria";
function salvar(){
    const carro = {
        marca: document.getElementById("marca").value,
        modelo: document.getElementById("modelo").value,
        ano: parseFloat(document.getElementById("ano").value),
        preco: parseInt(document.getElementById("preco").value),
        disponivel: document.getElementById("disponivel").value
    };

    fetch (url, {method: "POST", headers:{"Content-Type":"application/json"}, body: JSON.stringify(carro)}).then(() => listar());
}

function listar(){
    fetch(url)
    .then(res => res.json())
    .then(dados => {
        const lista = document.getElementById("lista");
        lista.innerHTML = "";

    dados.forEach(carro => {
    const li = document.createElement("li");
    li.innerText = `${carro.marca} - ${carro.modelo} - ${carro.ano} - ${carro.preco} - ${carro.disponivel}`;
    lista.appendChild(li);
    });
    });
}

listar();