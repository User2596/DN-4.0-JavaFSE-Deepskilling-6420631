import { useState } from "react";
import '../App.css';

const CurrencyConverter = ({ val = '', curr = '' }) => {
    const [amount, setAmount] = useState(val);
    const [currency, setCurrency] = useState(curr);
    const eurosToRupees = 100.04;
    const rupeesToEuros = 1 / eurosToRupees;

    const handleSubmit = () => {
        const trimmedCurrency = currency.trim().toLowerCase();
        let conCurrency = '';
        let result = 0;

        if (trimmedCurrency !== "euro" && trimmedCurrency !== "rupee") {
            alert("Error: Please enter either 'Euro' or 'Rupee' as the currency");
            return;
        }

        if (isNaN(parseFloat(amount))) {
            alert("Error: Please enter valid amount");
            return;
        }

        if (trimmedCurrency === "euro") {
            result = parseFloat(amount) * eurosToRupees;
            conCurrency = "Rupee";
        } else {
            result = parseFloat(amount) * rupeesToEuros;
            conCurrency = "Euro";
        }

        alert(`Converted to ${conCurrency} Amount is ${result.toFixed(2)}`);
    };

    return (
        <div>
            <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
            <div className="converter-container">
                <div className="form-row">
                    <label htmlFor="amount">Amount:</label>
                    <input
                        type="number"
                        name="amount"
                        value={amount}
                        onChange={(e) => setAmount(e.target.value)}
                    />
                </div>

                <div className="form-row">
                    <label htmlFor="currency">Currency:</label>
                    <textarea
                        name="currency"
                        maxLength={5}
                        defaultValue={curr}
                        onChange={(e) => setCurrency(e.target.value)}
                    />
                </div>

                <div>
                    <button onClick={handleSubmit} style={{ marginLeft: '50%' }}>Submit</button>
                </div>
            </div>
        </div>
    );
};

export default CurrencyConverter;
