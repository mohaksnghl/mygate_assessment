# mygate_assessment

## Heroku app link
https://mygate-assessment.herokuapp.com

## Assumptions
1. Street name in url is in capital letters
2. Date format in url is dd-MM-yyyy

## Path Mapping
●	Search by name of applicant  : /{applicant}

●	Search by expiration date, to find whose permits have expired : /trucks/expired/{date}

●	Search by street name : /trucks/{street}

●	Add new food truck entry to the dataset : /trucks

●	Add new food truck entry to the dataset : /trucks/{id}

●	Auto expiry of licenses : /trucks/autoexpire
