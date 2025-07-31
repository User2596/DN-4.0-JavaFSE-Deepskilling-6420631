import './App.css';
import { useState } from 'react';
import Greeting from './Components/Greeting';
import { LoginButton, LogoutButton } from './Components/Buttons';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const onClick = () => {
    setIsLoggedIn(!isLoggedIn);
  }

  let button = isLoggedIn
    ? <LogoutButton onClick={onClick} />
    : <LoginButton onClick={onClick} />;

  return (
    <div style={{ margin: '15%' }}>
      <Greeting isLoggedIn={isLoggedIn} />
      {button}
    </div>
  );
}

export default App;