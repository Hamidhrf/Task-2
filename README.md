# Task-2
matriculation number: 7219187

The Car class has seven properties:

id: An integer representing the car's unique identifier.
make: A string representing the car's make (e.g., Toyota, Honda).
model: A string representing the car's model.
yearOfManufacture: An integer representing the year the car was manufactured.
color: A string representing the car's color.
price: A double representing the car's price.
registrationNumber: A string representing the car's registration number.
The class has a constructor that is used to create a new Car object. Each property has a getter method to retrieve its value. The class also overrides the toString method to provide a string representation of a Car object.

The class provides three static methods for filtering an array of Car objects:

filterCarsByBrand: Filters cars by brand.
filterCarsByModelAndYears: Filters cars by model and age (i.e., how many years old the car is).
filterCarsByYearAndPrice: Filters cars by the year of manufacture and price.
There's also a saveToFile method that writes the toString representation of each Car object in a list to a file.

The main method creates an array of Car objects, performs the filtering operations using the above methods, and writes the results to separate files
