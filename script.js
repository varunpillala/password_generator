document.getElementById('generatebtn').addEventListener('click', function() {
    const passwordLength = parseInt(document.getElementById('passwordlength').value);
    const includeUpper = document.getElementById('includeupper').checked;
    const includeLower = document.getElementById('includelower').checked;
    const includeNum = document.getElementById('includenum').checked;
    const includeSym = document.getElementById('includesym').checked;
    const password = generatePassword(passwordLength, includeUpper, includeLower, includeNum, includeSym);
    document.getElementById('password').value = password;
});

function generatePassword(length, upper, lower, numbers, symbols) {
    let pool = '';
    if (upper) pool += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    if (lower) pool += 'abcdefghijklmnopqrstuvwxyz';
    if (numbers) pool += '1234567890';
    if (symbols) pool += '!@#$%^&*()_=+\\/~?';
    
    let password = '';
    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * pool.length);
        password += pool.charAt(randomIndex);
    }
    return password;
}
