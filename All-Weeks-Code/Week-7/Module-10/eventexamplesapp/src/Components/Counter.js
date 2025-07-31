import { useState } from "react"

export const Counter = ({ count = 0 }) => {
    const [counter, setCounter] = useState(count);

    const increment = () => {
        setCounter(counter + 1);
        sayHello();
    }

    const decrement = () => {
        setCounter(counter - 1);
    }

    const sayHello = () => {
        alert("Hello! Member1");
    }

    return (
        <>
            <p> {counter} </p>
            <button onClick={increment}> Increment </button><br />
            <button onClick={decrement}> Decrement </button><br />
        </>
    );
}

export const EventButtons = () => {
    function sayWelcome(message) {
        alert(message);
    }

    const onPress = (e) => {
        console.log(e);
        alert("I was clicked");
    }

    return (
        <>
            <button onClick={() => sayWelcome("welcome")}> Say welcome </button><br />
            <button onClick={(e) => onPress(e)}> Click on me </button><br />
        </>
    );
}