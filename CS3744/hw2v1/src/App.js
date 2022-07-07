import React from 'react';
import { makeStyles, createStyles, Theme } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';

const styleForOdd = makeStyles((theme: Theme) =>
    createStyles({
        paper: {
            color: 'black',
            padding: theme.spacing(2),
            textAlign: 'center',
            backgroundColor: 'yellow',
            width: '30%',
            display: 'block'
        }
    }),
);

const styleForEven = makeStyles((theme: Theme) =>
    createStyles({
        paper: {
            color: 'black',
            padding: theme.spacing(2),
            textAlign: 'center',
            backgroundColor: 'green',
            width: '30%',
            display: 'block'
        }
    }),
);

const styleForPrime = makeStyles((theme: Theme) =>
    createStyles({
        paper: {
            color: 'black',
            padding: theme.spacing(2),
            textAlign: 'center',
            backgroundColor: 'red',
            width: '30%',
            border: '1px solid black',
            display: 'block'
        }
    }),
);

function App() {
    function isPrime(n) {
        if (1 >= n) {
            return false;
        }
        for (let i = 2; i < n; i++) {
            if (n % i === 0) {
                return false;
            }
        }
        return true;
    }

    function Girds(number) {
        if (isPrime(number)) {
            const { paper } = styleForPrime();
            return (
                <Grid item xs={1} sm={1}>
                    <Paper className={paper}>{number}</Paper>
                </Grid>
            );
        }
        if (number % 2 === 1) {
            const { paper } = styleForOdd();
            return (
                <Grid item xs={1} sm={1}>
                    <Paper className={paper}>{number}</Paper>
                </Grid>
            );
        }

        const { paper } = styleForEven();
        return (
            <Grid item xs={1} sm={1}>
                <Paper className={paper}>{number}</Paper>
            </Grid>
        );
    }

    function Blocks(start, size) {
        const arr = [];
        for (let i = start; i < start + size; i++) {
            arr.push(Girds(i));
        }
        return (
            <div style={{display: 'flex'}}>
                {arr}
            </div>
        );
    }

    // Modify start and end to change the range of numbers
    let start = 1;
    let end = 64;
    const arr = [];

    if (end >= start) {
        let val = Math.floor((end - start + 1) / 8);
        let remainder = (end - start + 1) % 8;

        if (val > 0) {
            for (let i = 0; i < val; i++) {
                arr.push(Blocks(start + i * 8, 8));
            }
        }
        if (remainder > 0) {
            arr.push(Blocks(start + val * 8, remainder));
        }
    }

    return (
        <div>
            {arr}
        </div>
    );
}

export default App;






