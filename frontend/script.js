const form = document.getElementById("subscription-form");
const result = document.getElementById("result");
const errorMessage = document.getElementById("error-message");

form.addEventListener("submit", async function (event) {
    event.preventDefault();

    const customerName = document.getElementById("customerName").value;
    const planType = document.getElementById("planType").value;
    const months = document.getElementById("months").value;
    const monthlyPrice = document.getElementById("monthlyPrice").value;

    const formData = {
        customerName: customerName,
        planType: planType,
        months: Number(months),
        monthlyPrice: Number(monthlyPrice)
    };

    result.textContent = "Enviando...";
    errorMessage.textContent = "";

    try {
        const response = await fetch("http://localhost:8080/subscriptions/process", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        });

        if (!response.ok) {
            let errorMessageText = "Erro ao processar requisição";
            try {
                const errorJson = await response.json();
                errorMessageText = errorJson.error || JSON.stringify(errorJson);
            } catch {
                errorMessageText = await response.text();
            }
            throw new Error(errorMessageText);
        }

        const data = await response.json();
        result.innerHTML = `
            <div class="result-card">
            <h3>${data.message}</h3>
            <p><strong>Cliente:</strong> ${data.customerName}</p>
            <p><strong>Plano:</strong> ${data.planType}</p>
            <p><strong>Valor final:</strong>R$ ${data.finalAmount.toLocaleString("pt-BR", {
            minimumFractionDigits: 2, maximumFractionDigits: 2})}</p>
            </div>
        `;
        form.reset();
    } catch (error){
        result.innerHTML = `<div class="error-card">
            <h3>Não foi possível processar a assinatura</h3>
            <p>${error.message}</p>
            </div>
        `;
    errorMessage.textContent = "";
    }
});