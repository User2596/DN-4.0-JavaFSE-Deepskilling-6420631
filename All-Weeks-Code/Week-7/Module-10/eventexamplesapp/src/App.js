import './App.css';
import { Counter, EventButtons } from './Components/Counter';
import CurrencyConverter from './Components/CurrencyConverter';

function App() {
  return (
    <div>
      <Counter />
      <EventButtons />
      <CurrencyConverter />
    </div>
  );
}

export default App;