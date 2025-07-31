import './App.css';
import { officeList, OfficeSpaceRentalApp } from './Components/OfficeSpaces';

function App() {
  return (
    <OfficeSpaceRentalApp offices={officeList} />
  );
}

export default App;
