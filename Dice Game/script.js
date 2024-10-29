let currentPlayer = 1;
let playerResults = [];
let totalPlayers = 0;

// Initialize the game by setting up the number of players
function initializeGame() {
  const numPlayers = parseInt(document.getElementById('players').value);
  const resultsDiv = document.getElementById('results');
  const scoreboardDiv = document.getElementById('scoreboard');

  resultsDiv.innerHTML = ''; // Clear previous results
  scoreboardDiv.innerHTML = ''; // Clear previous scoreboard
  playerResults = []; // Reset results
  currentPlayer = 1; // Reset to player 1

  if (isNaN(numPlayers) || numPlayers < 2) {
    alert('Please enter a valid number of players (minimum 2).');
    return;
  }

  totalPlayers = numPlayers;
  showPlayerTurn(); // Start the game with Player 1's turn
}

// Display the current player's turn and roll button
function showPlayerTurn() {
  const resultsDiv = document.getElementById('results');

  const playerMessage = document.createElement('div');
  playerMessage.className = 'player-result';
  playerMessage.innerText = `Player ${currentPlayer}, it's your turn!`;

  const rollButton = document.createElement('button');
  rollButton.innerText = 'Roll Dice';
  rollButton.onclick = rollDice;

  resultsDiv.innerHTML = ''; // Clear previous content
  resultsDiv.appendChild(playerMessage);
  resultsDiv.appendChild(rollButton);
}

// Roll the dice for the current player with animation
function rollDice() {
  const resultsDiv = document.getElementById('results');

  // Create a dice element to display the rolling animation
  const dice = document.createElement('div');
  dice.className = 'dice';
  dice.innerText = '🎲'; // Initial dice icon

  const playerMessage = document.createElement('div');
  playerMessage.className = 'player-result';
  playerMessage.innerText = `Player ${currentPlayer} is rolling...`;
  playerMessage.appendChild(dice);

  resultsDiv.innerHTML = ''; // Clear content
  resultsDiv.appendChild(playerMessage);

  // Simulate dice roll with animation delay
  setTimeout(() => {
    const diceRoll = Math.floor(Math.random() * 6) + 1;
    playerResults.push({ player: currentPlayer, score: diceRoll });

    playerMessage.innerText = `Player ${currentPlayer}: 🎲 ${diceRoll}`;
    updateScoreboard(currentPlayer, diceRoll); // Update scoreboard
    moveToNextPlayer();
  }, 2000); // 2-second delay for animation
}

// Update the scoreboard with the current player's score
function updateScoreboard(player, score) {
  const scoreboardDiv = document.getElementById('scoreboard');
  const scoreEntry = document.createElement('div');
  scoreEntry.className = 'score';
  scoreEntry.innerText = `Player ${player}: ${score}`;
  scoreboardDiv.appendChild(scoreEntry);
}

// Move to the next player or determine the winner if all players have rolled
function moveToNextPlayer() {
  currentPlayer++;

  if (currentPlayer > totalPlayers) {
    determineWinner(); // All players have rolled, determine the winner
  } else {
    setTimeout(showPlayerTurn, 1000); // Move to next player's turn after 1 second
  }
}

// Determine the winner(s) based on the highest dice roll
function determineWinner() {
  const maxScore = Math.max(...playerResults.map(p => p.score));
  const winners = playerResults.filter(p => p.score === maxScore);

  const resultsDiv = document.getElementById('results');
  const winnerMessage = document.createElement('div');
  winnerMessage.className = 'player-result';

  if (winners.length === 1) {
    winnerMessage.innerText = `🎉 Player ${winners[0].player} wins with a roll of ${maxScore}! 🎉`;
  } else {
    const winnerNames = winners.map(w => `Player ${w.player}`).join(', ');
    winnerMessage.innerText = `🤝 It's a tie! Winners: ${winnerNames} with a roll of ${maxScore}.`;
  }

  resultsDiv.appendChild(winnerMessage);
}
