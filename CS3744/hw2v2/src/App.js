import React from 'react';

function App() {
  function isPrime(n) {
    if (n <= 1) {
        return false;
    }
    for (let i = 2; i < n; i++) {
      if (n % i === 0) {
        return false;
      }
    }
    return true;
  }

  function SingleGrid(number) {
    if (isPrime(number)) {
      return (
          <div style={{color: 'black',
                textAlign: 'center',
                backgroundColor: 'red',
                width: '94%',
                border: '2px solid black'}}>
                {number}
          </div>
      )
    }
    else if (number % 2 === 0) {
        return (
            <div style={{color: 'black',
                textAlign: 'center',
                backgroundColor: 'green',
                width: '100%'}}>
                {number}
            </div>
        )
    }
    else if (Math.abs(number % 2) === 1) {
        return (
            <div style={{color: 'black',
                textAlign: 'center',
                backgroundColor: 'yellow',
                width: '100%'}}>
                {number}
            </div>
        )
    }
  }

  function Grids(props) {
    let grids = [];
    for (let i = props.start; i <= props.end; i++) {
      grids.push(SingleGrid(i));
    }
    return (
        <div style={{display: 'grid',
            gridTemplateColumns: 'repeat(8, 50px)',
            gridGap: "5px 20px",
            paddingLeft: "5px",
            paddingTop: "5px"
            }}>
            {grids}
        </div>
    )
  }

  return (
    <div>
        <Grids start={1} end={101}/>
    </div>
  );
}

export default App;
