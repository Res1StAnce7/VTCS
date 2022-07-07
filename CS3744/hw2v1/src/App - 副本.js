import React from 'react';
import CreateRoot from 'react-dom/client';
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

function isPrime(n) {
    if (1 >= n) {
        return false;
    }
    for (let i = 2; i < n; i++) {
        if (n % i ===0) {
            return false;
        }
    }
    return true;
}

function Girds(number) {
        if (isPrime(number)) {
            const {paper} = styleForPrime();
            return (
                    <Grid item xs={1} sm={1}>
                        <Paper className={paper}>{number}</Paper>
                    </Grid>
            );
        }
        if  (number % 2 === 1) {
            const {paper} = styleForOdd();
            return (
                    <Grid item xs={1} sm={1}>
                        <Paper className={paper}>{number}</Paper>
                    </Grid>
            );
        }

        const {paper} = styleForEven();
        return (
                <Grid item xs={1} sm={1}>
                    <Paper className={paper}>{number}</Paper>
                </Grid>
        );
}

const root = CreateRoot.createRoot(document.getElementById('root'));

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

function GenerateBlocks() {
    let start = 0;
    let end = 100;
    const arr = [];

    if (end >= start){
        let val = Math.floor((end - start + 1) / 10);
        let remainder = (end - start + 1) % 10;

        if (val > 0) {
            for (let i = 0; i < val; i++) {
                arr.push(Blocks(start + i * 10, 10));
            }
        }
        if (remainder > 0) {
            arr.push(Blocks(start + val * 10, remainder));
        }
    }

    return (
        <div>
            {arr}
        </div>
    );
}

root.render(
    <div style={{padding: '20px'}}>
        <GenerateBlocks />
    </div>
);






