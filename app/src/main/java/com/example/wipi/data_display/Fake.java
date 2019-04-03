package com.example.wipi.data_display;

import com.example.wipi.models.Attendance;
import com.example.wipi.models.MapJoins;
import com.example.wipi.models.Person;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.example.wipi.models.Attendance.TIMESTAMP_FORMAT;

public class Fake {

    public static final String NETWORK_NAME = "CP Registration";

    public static final String REGISTRATION_URL = "reg.example.com";

    private static final String maleNames[] = {"Aaron"//, "Abdul", "Abe", "Abel", "Abraham", "Adam", "Adan", "Adolfo", "Adolph", "Adrian", "Agustin", "Ahmad", "Al", "Alan", "Albert", "Alberto", "Alden", "Aldo", "Alejandro", "Alex", "Alexander", "Alexis", "Alfonso", "Alfred", "Alfredo", "Ali", "Allan", "Allen", "Alonzo", "Alphonse", "Alphonso", "Alton", "Alva", "Alvaro", "Alvin", "Amos", "Anderson", "Andre", "Andrea", "Andres", "Andrew", "Andy", "Angel", "Angelo", "Anthony", "Antoine", "Anton", "Antonio", "Antony", "Antwan", "Archie", "Ariel", "Armand", "Armando", "Arnold", "Arnulfo", "Aron", "Art", "Arthur", "Arturo", "Ashley", "Aubrey", "August", "Augustine", "Aurelio", "Austin", "Avery", "Barney", "Barry", "Bart", "Barton", "Basil", "Beau", "Ben", "Benito", "Benjamin", "Bennett", "Bennie", "Benny", "Bernard", "Bernardo", "Bernie", "Bert", "Bill", "Billie", "Billy", "Blaine", "Blair", "Blake", "Bob", "Bobbie", "Bobby", "Booker", "Boris", "Boyd", "Brad", "Bradford", "Bradley", "Brady", "Brain", "Branden", "Brandon", "Brendan", "Brent", "Bret", "Brett", "Brian", "Brock", "Brooks", "Bruce", "Bruno", "Bryan", "Bryant", "Bryce", "Bryon", "Buddy", "Buford", "Burt", "Burton", "Byron", "Caleb", "Calvin", "Cameron", "Carey", "Carl", "Carlo", "Carlos", "Carlton", "Carmelo", "Carmen", "Carmine", "Carroll", "Carson", "Carter", "Cary", "Casey", "Cecil", "Cedric", "Cesar", "Chad", "Chadwick", "Chance", "Charles", "Charley", "Charlie", "Chase", "Chester", "Chris", "Christian", "Christopher", "Chuck", "Clair", "Clarence", "Clark", "Claude", "Clay", "Clayton", "Clement", "Cleo", "Cleveland", "Cliff", "Clifford", "Clifton", "Clint", "Clinton", "Clyde", "Cody", "Colby", "Cole", "Coleman", "Colin", "Collin", "Conrad", "Corey", "Cornelius", "Cornell", "Cory", "Courtney", "Coy", "Craig", "Cruz", "Curt", "Curtis", "Cyril", "Cyrus", "Dale", "Dallas", "Dalton", "Damian", "Damien", "Damon", "Dan", "Dana", "Dane", "Danial", "Daniel", "Danny", "Dante", "Daren", "Darin", "Darius", "Darnell", "Darrel", "Darrell", "Darren", "Darrin", "Darryl", "Darwin", "Daryl", "Dave", "David", "Davis", "Dean", "Deandre", "Delbert", "Delmar", "Demetrius", "Denis", "Dennis", "Denny", "Denver", "Derek", "Derick", "Derrick", "Desmond", "Devin", "Devon", "Dewayne", "Dewey", "Dexter", "Dick", "Diego", "Dino", "Dion", "Dirk", "Domingo", "Dominic", "Dominick", "Dominique", "Don", "Donald", "Donnell", "Donnie", "Donny", "Donovan", "Dorian", "Doug", "Douglas", "Doyle", "Drew", "Duane", "Dudley", "Duncan", "Dustin", "Dusty", "Dwayne", "Dwight", "Dylan", "Earl", "Earle", "Earnest", "Ed", "Eddie", "Eddy", "Edgar", "Edmond", "Edmund", "Eduardo", "Edward", "Edwardo", "Edwin", "Efrain", "Efren", "Elbert", "Eldon", "Eli", "Elias", "Elijah", "Eliseo", "Elliot", "Elliott", "Ellis", "Elmer", "Elmo", "Eloy", "Elton", "Elvin", "Elvis", "Elwood", "Emanuel", "Emerson", "Emery", "Emil", "Emile", "Emilio", "Emmanuel", "Emmett", "Emory", "Enrique", "Eric", "Erich", "Erick", "Erik", "Erin", "Ernest", "Ernesto", "Ernie", "Errol", "Ervin", "Erwin", "Esteban", "Ethan", "Eugene", "Eugenio", "Evan", "Everett", "Everette", "Ezra", "Fabian", "Federico", "Felipe", "Felix", "Ferdinand", "Fernando", "Fidel", "Fletcher", "Floyd", "Forest", "Forrest", "Francis", "Francisco", "Frank", "Frankie", "Franklin", "Fred", "Freddie", "Freddy", "Frederic", "Frederick", "Fredrick", "Freeman", "Gabriel", "Gail", "Gale", "Galen", "Garland", "Garrett", "Garry", "Garth", "Gary", "Gavin", "Genaro", "Gene", "Geoffrey", "George", "Gerald", "Gerard", "Gerardo", "German", "Gerry", "Gil", "Gilbert", "Gilberto", "Giovanni", "Glen", "Glenn", "Gonzalo", "Gordon", "Grady", "Graham", "Grant", "Greg", "Gregg", "Gregorio", "Gregory", "Grover", "Guadalupe", "Guillermo", "Gus", "Gustavo", "Guy", "Hal", "Hans", "Harlan", "Harley", "Harold", "Harris", "Harrison", "Harry", "Harvey", "Heath", "Hector", "Henry", "Herbert", "Heriberto", "Herman", "Herschel", "Hershel", "Hiram", "Hollis", "Homer", "Horace", "Houston", "Howard", "Hubert", "Hugh", "Hugo", "Humberto", "Hung", "Hunter", "Ian", "Ignacio", "Ira", "Irvin", "Irving", "Irwin", "Isaac", "Isaiah", "Isiah", "Isidro", "Ismael", "Israel", "Issac", "Ivan", "Ivory", "Jack", "Jackie", "Jackson", "Jacob", "Jacques", "Jaime", "Jake", "Jamal", "Jamar", "Jame", "Jamel", "James", "Jamie", "Jan", "Jared", "Jarrett", "Jarrod", "Jarvis", "Jason", "Jasper", "Javier", "Jay", "Jayson", "Jean", "Jeff", "Jefferson", "Jeffery", "Jeffrey", "Jeffry", "Jerald", "Jeremiah", "Jeremy", "Jermaine", "Jerome", "Jerrod", "Jerry", "Jess", "Jesse", "Jessie", "Jesus", "Jim", "Jimmie", "Jimmy", "Joan", "Joaquin", "Jody", "Joe", "Joel", "Joesph", "Joey", "John", "Johnathan", "Johnathon", "Johnie", "Johnnie", "Johnny", "Jon", "Jonas", "Jonathan", "Jonathon", "Jordan", "Jorge", "Jose", "Josef", "Joseph", "Josh", "Joshua", "Josue", "Juan", "Jules", "Julian", "Julio", "Julius", "Junior", "Justin", "Kareem", "Karl", "Keith", "Kelly", "Kelvin", "Ken", "Kendall", "Kendrick", "Kenneth", "Kennith", "Kenny", "Kent", "Kermit", "Kerry", "Kevin", "Kieth", "Kim", "Kirby", "Kirk", "Kris", "Kristopher", "Kurt", "Kurtis", "Kyle", "Lamar", "Lamont", "Lance", "Landon", "Lane", "Lanny", "Larry", "Laurence", "Lavern", "Laverne", "Lawrence", "Lazaro", "Lee", "Leland", "Lemuel", "Leo", "Leon", "Leonard", "Leonardo", "Leonel", "Leopoldo", "Leroy", "Les", "Leslie", "Lester", "Levi", "Lewis", "Lincoln", "Lindsey", "Linwood", "Lionel", "Lloyd", "Logan", "Lon", "Lonnie", "Loren", "Lorenzo", "Louie", "Louis", "Lowell", "Loyd", "Lucas", "Luciano", "Lucien", "Lucio", "Luis", "Luke", "Luther", "Lyle", "Lynn", "Mack", "Major", "Malcolm", "Manuel", "Marc", "Marcel", "Marcelino", "Marco", "Marcos", "Marcus", "Margarito", "Mariano", "Mario", "Marion", "Mark", "Marlin", "Marlon", "Marquis", "Marshall", "Martin", "Marty", "Marvin", "Mary", "Mason", "Mathew", "Matt", "Matthew", "Maurice", "Mauricio", "Max", "Maxwell", "Maynard", "Melvin", "Merle", "Merlin", "Merrill", "Mervin", "Micah", "Michael", "Micheal", "Michel", "Mickey", "Miguel", "Mike", "Miles", "Millard", "Milton", "Mitch", "Mitchel", "Mitchell", "Mohammad", "Mohammed", "Moises", "Monroe", "Monte", "Monty", "Morgan", "Morris", "Morton", "Moses", "Murray", "Myles", "Myron", "Nathan", "Nathaniel", "Neal", "Ned", "Neil", "Nelson", "Nestor", "Nicholas", "Nick", "Nickolas", "Nicolas", "Nigel", "Noah", "Noe", "Noel", "Nolan", "Norbert", "Norman", "Normand", "Norris", "Numbers", "Octavio", "Odell", "Oliver", "Ollie", "Omar", "Orlando", "Orville", "Oscar", "Osvaldo", "Otis", "Otto", "Owen", "Pablo", "Parker", "Pasquale", "Pat", "Patrick", "Paul", "Pedro", "Percy", "Perry", "Pete", "Peter", "Phil", "Philip", "Phillip", "Pierre", "Preston", "Quentin", "Quincy", "Quinton", "Rafael", "Ralph", "Ramiro", "Ramon", "Randal", "Randall", "Randell", "Randolph", "Randy", "Raphael", "Raul", "Ray", "Raymond", "Raymundo", "Reed", "Refugio", "Reggie", "Reginald", "Reid", "Reinaldo", "Rene", "Reuben", "Rex", "Reynaldo", "Ricardo", "Rich", "Richard", "Rick", "Rickey", "Rickie", "Ricky", "Rigoberto", "Riley", "Rob", "Robbie", "Robby", "Robert", "Roberto", "Robin", "Rocco", "Rocky", "Rod", "Roderick", "Rodger", "Rodney", "Rodolfo", "Rodrick", "Rodrigo", "Rogelio", "Roger", "Roland", "Rolando", "Roman", "Romeo", "Ron", "Ronald", "Ronnie", "Ronny", "Roosevelt", "Rory", "Roscoe", "Ross", "Roy", "Royal", "Royce", "Ruben", "Rubin", "Rudolph", "Rudy", "Rufus", "Russ", "Russel", "Russell", "Rusty", "Ryan", "Salvador", "Salvatore", "Sam", "Sammie", "Sammy", "Samuel", "Sandy", "Sanford", "Santiago", "Santos", "Saul", "Scot", "Scott", "Scottie", "Scotty", "Sean", "Sebastian", "Sergio", "Seth", "Seymour", "Shane", "Shannon", "Shaun", "Shawn", "Shelby", "Sheldon", "Shelton", "Sherman", "Sidney", "Silas", "Simon", "Solomon", "Son", "Sonny", "Spencer", "Stacey", "Stacy", "Stan", "Stanley", "Stefan", "Stephan", "Stephen", "Sterling", "Steve", "Steven", "Stevie", "Stewart", "Stuart", "Sydney", "Sylvester", "Taylor", "Ted", "Teddy", "Terence", "Terrance", "Terrell", "Terrence", "Terry", "Thad", "Thaddeus", "Theodore", "Theron", "Thomas", "Thurman", "Tim", "Timmy", "Timothy", "Toby", "Todd", "Tom", "Tomas", "Tommie", "Tommy", "Tony", "Tracey", "Tracy", "Travis", "Trent", "Trenton", "Trevor", "Tristan", "Troy", "Truman", "Ty", "Tyler", "Tyrone", "Tyson", "Ulysses", "Valentin", "Van", "Vance", "Vaughn", "Vern", "Vernon", "Vicente", "Victor", "Vince", "Vincent", "Virgil", "Vito", "Wade", "Wallace", "Walter", "Ward", "Warren", "Wayne", "Weldon", "Wendell", "Wesley", "Weston", "Wilbert", "Wilbur", "Wilburn", "Wiley", "Wilford", "Wilfred", "Wilfredo", "Will", "Willard", "William", "Williams", "Willie", "Willis", "Wilmer", "Wilson", "Winfred", "Winston", "Wm", "Woodrow", "Wyatt", "Xavier", "Young", "Zachary", "Zachery", "Zane"
    };
    private static final String femaleNames[] = {"Abby"//, "Abigail", "Ada", "Addie", "Adela", "Adele", "Adeline", "Adrian", "Adriana", "Adrienne", "Agnes", "Aida", "Aileen", "Aimee", "Aisha", "Alana", "Alba", "Alberta", "Alejandra", "Alexandra", "Alexandria", "Alexis", "Alfreda", "Alice", "Alicia", "Aline", "Alisa", "Alisha", "Alison", "Alissa", "Allie", "Allison", "Allyson", "Alma", "Alta", "Althea", "Alyce", "Alyson", "Alyssa", "Amalia", "Amanda", "Amber", "Amelia", "Amie", "Amparo", "Amy", "Ana", "Anastasia", "Andrea", "Angel", "Angela", "Angelia", "Angelica", "Angelina", "Angeline", "Angelique", "Angelita", "Angie", "Anita", "Ann", "Anna", "Annabelle", "Anne", "Annette", "Annie", "Annmarie", "Antoinette", "Antonia", "April", "Araceli", "Arlene", "Arline", "Ashlee", "Ashley", "Audra", "Audrey", "Augusta", "Aurelia", "Aurora", "Autumn", "Ava", "Avis", "Barbara", "Barbra", "Beatrice", "Beatriz", "Becky", "Belinda", "Benita", "Bernadette", "Bernadine", "Bernice", "Berta", "Bertha", "Bertie", "Beryl", "Bessie", "Beth", "Bethany", "Betsy", "Bette", "Bettie", "Betty", "Bettye", "Beulah", "Beverley", "Beverly", "Bianca", "Billie", "Blanca", "Blanche", "Bobbi", "Bobbie", "Bonita", "Bonnie", "Brandi", "Brandie", "Brandy", "Brenda", "Briana", "Brianna", "Bridget", "Bridgett", "Bridgette", "Brigitte", "Britney", "Brittany", "Brittney", "Brooke", "Caitlin", "Callie", "Camille", "Candace", "Candice", "Candy", "Cara", "Carey", "Carissa", "Carla", "Carlene", "Carly", "Carmela", "Carmella", "Carmen", "Carol", "Carole", "Carolina", "Caroline", "Carolyn", "Carrie", "Casandra", "Casey", "Cassandra", "Cassie", "Catalina", "Catherine", "Cathleen", "Cathryn", "Cathy", "Cecelia", "Cecile", "Cecilia", "Celeste", "Celia", "Celina", "Chandra", "Charity", "Charlene", "Charlotte", "Charmaine", "Chasity", "Chelsea", "Cheri", "Cherie", "Cherry", "Cheryl", "Chris", "Christa", "Christi", "Christian", "Christie", "Christina", "Christine", "Christy", "Chrystal", "Cindy", "Claire", "Clara", "Clare", "Clarice", "Clarissa", "Claudette", "Claudia", "Claudine", "Cleo", "Coleen", "Colette", "Colleen", "Concepcion", "Concetta", "Connie", "Constance", "Consuelo", "Cora", "Corina", "Corine", "Corinne", "Cornelia", "Corrine", "Courtney", "Cristina", "Crystal", "Cynthia", "Daisy", "Dale", "Dana", "Danielle", "Daphne", "Darcy", "Darla", "Darlene", "Dawn", "Deana", "Deann", "Deanna", "Deanne", "Debbie", "Debora", "Deborah", "Debra", "Dee", "Deena", "Deidre", "Deirdre", "Delia", "Della", "Delores", "Deloris", "Dena", "Denise", "Desiree", "Diana", "Diane", "Diann", "Dianna", "Dianne", "Dina", "Dionne", "Dixie", "Dollie", "Dolly", "Dolores", "Dominique", "Dona", "Donna", "Dora", "Doreen", "Doris", "Dorothea", "Dorothy", "Dorthy", "Earlene", "Earline", "Earnestine", "Ebony", "Eddie", "Edith", "Edna", "Edwina", "Effie", "Eileen", "Elaine", "Elba", "Eleanor", "Elena", "Elinor", "Elisa", "Elisabeth", "Elise", "Eliza", "Elizabeth", "Ella", "Ellen", "Elma", "Elnora", "Eloise", "Elsa", "Elsie", "Elva", "Elvia", "Elvira", "Emilia", "Emily", "Emma", "Enid", "Erica", "Ericka", "Erika", "Erin", "Erma", "Erna", "Ernestine", "Esmeralda", "Esperanza", "Essie", "Estela", "Estella", "Estelle", "Ester", "Esther", "Ethel", "Etta", "Eugenia", "Eula", "Eunice", "Eva", "Evangelina", "Evangeline", "Eve", "Evelyn", "Faith", "Fannie", "Fanny", "Fay", "Faye", "Felecia", "Felicia", "Fern", "Flora", "Florence", "Florine", "Flossie", "Fran", "Frances", "Francesca", "Francine", "Francis", "Francisca", "Frankie", "Freda", "Freida", "Frieda", "Gabriela", "Gabrielle", "Gail", "Gale", "Gay", "Gayle", "Gena", "Geneva", "Genevieve", "Georgette", "Georgia", "Georgina", "Geraldine", "Gertrude", "Gilda", "Gina", "Ginger", "Gladys", "Glenda", "Glenna", "Gloria", "Goldie", "Grace", "Gracie", "Graciela", "Greta", "Gretchen", "Guadalupe", "Gwen", "Gwendolyn", "Haley", "Hallie", "Hannah", "Harriet", "Harriett", "Hattie", "Hazel", "Heather", "Heidi", "Helen", "Helena", "Helene", "Helga", "Henrietta", "Herminia", "Hester", "Hilary", "Hilda", "Hillary", "Hollie", "Holly", "Hope", "Ida", "Ila", "Ilene", "Imelda", "Imogene", "Ina", "Ines", "Inez", "Ingrid", "Irene", "Iris", "Irma", "Isabel", "Isabella", "Isabelle", "Iva", "Ivy", "Jackie", "Jacklyn", "Jaclyn", "Jacqueline", "Jacquelyn", "Jaime", "James", "Jami", "Jamie", "Jan", "Jana", "Jane", "Janell", "Janelle", "Janet", "Janette", "Janice", "Janie", "Janine", "Janis", "Janna", "Jannie", "Jasmine", "Jayne", "Jean", "Jeanette", "Jeanie", "Jeanine", "Jeanne", "Jeannette", "Jeannie", "Jeannine", "Jenifer", "Jenna", "Jennie", "Jennifer", "Jenny", "Jeri", "Jerri", "Jerry", "Jessica", "Jessie", "Jewel", "Jewell", "Jill", "Jillian", "Jimmie", "Jo", "Joan", "Joann", "Joanna", "Joanne", "Jocelyn", "Jodi", "Jodie", "Jody", "Johanna", "John", "Johnnie", "Jolene", "Joni", "Jordan", "Josefa", "Josefina", "Josephine", "Josie", "Joy", "Joyce", "Juana", "Juanita", "Judith", "Judy", "Julia", "Juliana", "Julianne", "Julie", "Juliet", "Juliette", "June", "Justine", "Kaitlin", "Kara", "Karen", "Kari", "Karin", "Karina", "Karla", "Karyn", "Kasey", "Kate", "Katelyn", "Katharine", "Katherine", "Katheryn", "Kathie", "Kathleen", "Kathrine", "Kathryn", "Kathy", "Katie", "Katina", "Katrina", "Katy", "Kay", "Kaye", "Kayla", "Keisha", "Kelley", "Kelli", "Kellie", "Kelly", "Kelsey", "Kendra", "Kenya", "Keri", "Kerri", "Kerry", "Kim", "Kimberley", "Kimberly", "Kirsten", "Kitty", "Kris", "Krista", "Kristen", "Kristi", "Kristie", "Kristin", "Kristina", "Kristine", "Kristy", "Krystal", "Lacey", "Lacy", "Ladonna", "Lakeisha", "Lakisha", "Lana", "Lara", "Latasha", "Latisha", "Latonya", "Latoya", "Laura", "Laurel", "Lauren", "Lauri", "Laurie", "Laverne", "Lavonne", "Lawanda", "Lea", "Leah", "Leann", "Leanna", "Leanne", "Lee", "Leigh", "Leila", "Lela", "Lelia", "Lena", "Lenora", "Lenore", "Leola", "Leona", "Leonor", "Lesa", "Lesley", "Leslie", "Lessie", "Leta", "Letha", "Leticia", "Letitia", "Lidia", "Lila", "Lilia", "Lilian", "Liliana", "Lillian", "Lillie", "Lilly", "Lily", "Lina", "Linda", "Lindsay", "Lindsey", "Lisa", "Liz", "Liza", "Lizzie", "Lois", "Lola", "Lolita", "Lora", "Loraine", "Lorena", "Lorene", "Loretta", "Lori", "Lorie", "Lorna", "Lorraine", "Lorrie", "Lottie", "Lou", "Louella", "Louisa", "Louise", "Lourdes", "Luann", "Lucia", "Lucile", "Lucille", "Lucinda", "Lucy", "Luella", "Luisa", "Lula", "Lupe", "Luz", "Lydia", "Lynda", "Lynette", "Lynn", "Lynne", "Lynnette", "Mabel", "Mable", "Madeleine", "Madeline", "Madelyn", "Madge", "Mae", "Magdalena", "Maggie", "Mai", "Malinda", "Mallory", "Mamie", "Mandy", "Manuela", "Mara", "Marcella", "Marci", "Marcia", "Marcie", "Marcy", "Margaret", "Margarita", "Margery", "Margie", "Margo", "Margret", "Marguerite", "Mari", "Maria", "Marian", "Mariana", "Marianne", "Maribel", "Maricela", "Marie", "Marietta", "Marilyn", "Marina", "Marion", "Marisa", "Marisol", "Marissa", "Maritza", "Marjorie", "Marla", "Marlene", "Marquita", "Marsha", "Marta", "Martha", "Martina", "Marva", "Mary", "Maryann", "Maryanne", "Maryellen", "Marylou", "Matilda", "Mattie", "Maude", "Maura", "Maureen", "Mavis", "Maxine", "May", "Mayra", "Meagan", "Megan", "Meghan", "Melanie", "Melba", "Melinda", "Melisa", "Melissa", "Melody", "Melva", "Mercedes", "Meredith", "Merle", "Mia", "Michael", "Michele", "Michelle", "Milagros", "Mildred", "Millicent", "Millie", "Mindy", "Minerva", "Minnie", "Miranda", "Miriam", "Misty", "Mitzi", "Mollie", "Molly", "Mona", "Monica", "Monique", "Morgan", "Muriel", "Myra", "Myrna", "Myrtle", "Nadia", "Nadine", "Nancy", "Nanette", "Nannie", "Naomi", "Natalia", "Natalie", "Natasha", "Nelda", "Nell", "Nellie", "Nettie", "Neva", "Nichole", "Nicole", "Nikki", "Nina", "Nita", "Noelle", "Noemi", "Nola", "Nona", "Nora", "Noreen", "Norma", "Odessa", "Ofelia", "Ola", "Olga", "Olive", "Olivia", "Ollie", "Opal", "Ophelia", "Ora", "Paige", "Pam", "Pamela", "Pansy", "Pat", "Patrica", "Patrice", "Patricia", "Patsy", "Patti", "Patty", "Paula", "Paulette", "Pauline", "Pearl", "Pearlie", "Peggy", "Penelope", "Penny", "Petra", "Phoebe", "Phyllis", "Polly", "Priscilla", "Queen", "Rachael", "Rachel", "Rachelle", "Rae", "Ramona", "Randi", "Raquel", "Reba", "Rebecca", "Rebekah", "Regina", "Rena", "Rene", "Renee", "Reva", "Reyna", "Rhea", "Rhoda", "Rhonda", "Rita", "Robbie", "Robert", "Roberta", "Robin", "Robyn", "Rochelle", "Ronda", "Rosa", "Rosalie", "Rosalind", "Rosalinda", "Rosalyn", "Rosanna", "Rosanne", "Rosario", "Rose", "Roseann", "Rosella", "Rosemarie", "Rosemary", "Rosetta", "Rosie", "Roslyn", "Rowena", "Roxanne", "Roxie", "Ruby", "Ruth", "Ruthie", "Sabrina", "Sadie", "Sallie", "Sally", "Samantha", "Sandra", "Sandy", "Sara", "Sarah", "Sasha", "Saundra", "Savannah", "Selena", "Selma", "Serena", "Shana", "Shanna", "Shannon", "Shari", "Sharlene", "Sharon", "Sharron", "Shauna", "Shawn", "Shawna", "Sheena", "Sheila", "Shelby", "Shelia", "Shelley", "Shelly", "Sheree", "Sheri", "Sherri", "Sherrie", "Sherry", "Sheryl", "Shirley", "Silvia", "Simone", "Socorro", "Sofia", "Sondra", "Sonia", "Sonja", "Sonya", "Sophia", "Sophie", "Stacey", "Staci", "Stacie", "Stacy", "Stefanie", "Stella", "Stephanie", "Sue", "Summer", "Susan", "Susana", "Susanna", "Susanne", "Susie", "Suzanne", "Suzette", "Sybil", "Sylvia", "Tabatha", "Tabitha", "Tamara", "Tameka", "Tamera", "Tami", "Tamika", "Tammi", "Tammie", "Tammy", "Tamra", "Tania", "Tanisha", "Tanya", "Tara", "Tasha", "Taylor", "Teresa", "Teri", "Terra", "Terri", "Terrie", "Terry", "Tessa", "Thelma", "Theresa", "Therese", "Tia", "Tiffany", "Tina", "Tisha", "Tommie", "Toni", "Tonia", "Tonya", "Tracey", "Traci", "Tracie", "Tracy", "Tricia", "Trina", "Trisha", "Trudy", "Twila", "Ursula", "Valarie", "Valeria", "Valerie", "Vanessa", "Velma", "Vera", "Verna", "Veronica", "Vicki", "Vickie", "Vicky", "Victoria", "Vilma", "Viola", "Violet", "Virgie", "Virginia", "Vivian", "Vonda", "Wanda", "Wendi", "Wendy", "Whitney", "Wilda", "Willa", "Willie", "Wilma", "Winifred", "Winnie", "Yesenia", "Yolanda", "Young", "Yvette", "Yvonne", "Zelma"
    };
    private static final String surnames[] = {"Abbott"//, "Acevedo", "Acosta", "Adams", "Adkins", "Aguilar", "Aguirre", "Albert", "Alexander", "Alford", "Allen", "Allison", "Alston", "Alvarado", "Alvarez", "Anderson", "Andrews", "Anthony", "Armstrong", "Arnold", "Ashley", "Atkins", "Atkinson", "Austin", "Avery", "Avila", "Ayala", "Ayers", "Bailey", "Baird", "Baker", "Baldwin", "Ball", "Ballard", "Banks", "Barber", "Barker", "Barlow", "Barnes", "Barnett", "Barr", "Barrera", "Barrett", "Barron", "Barry", "Bartlett", "Barton", "Bass", "Bates", "Battle", "Bauer", "Baxter", "Beach", "Bean", "Beard", "Beasley", "Beck", "Becker", "Bell", "Bender", "Benjamin", "Bennett", "Benson", "Bentley", "Benton", "Berg", "Berger", "Bernard", "Berry", "Best", "Bird", "Bishop", "Black", "Blackburn", "Blackwell", "Blair", "Blake", "Blanchard", "Blankenship", "Blevins", "Bolton", "Bond", "Bonner", "Booker", "Boone", "Booth", "Bowen", "Bowers", "Bowman", "Boyd", "Boyer", "Boyle", "Bradford", "Bradley", "Bradshaw", "Brady", "Branch", "Bray", "Brennan", "Brewer", "Bridges", "Briggs", "Bright", "Britt", "Brock", "Brooks", "Brown", "Browning", "Bruce", "Bryan", "Bryant", "Buchanan", "Buck", "Buckley", "Buckner", "Bullock", "Burch", "Burgess", "Burke", "Burks", "Burnett", "Burns", "Burris", "Burt", "Burton", "Bush", "Butler", "Byers", "Byrd", "Cabrera", "Cain", "Calderon", "Caldwell", "Calhoun", "Callahan", "Camacho", "Cameron", "Campbell", "Campos", "Cannon", "Cantrell", "Cantu", "Cardenas", "Carey", "Carlson", "Carney", "Carpenter", "Carr", "Carrillo", "Carroll", "Carson", "Carter", "Carver", "Case", "Casey", "Cash", "Castaneda", "Castillo", "Castro", "Cervantes", "Chambers", "Chan", "Chandler", "Chaney", "Chang", "Chapman", "Charles", "Chase", "Chavez", "Chen", "Cherry", "Christensen", "Christian", "Church", "Clark", "Clarke", "Clay", "Clayton", "Clements", "Clemons", "Cleveland", "Cline", "Cobb", "Cochran", "Coffey", "Cohen", "Cole", "Coleman", "Collier", "Collins", "Colon", "Combs", "Compton", "Conley", "Conner", "Conrad", "Contreras", "Conway", "Cook", "Cooke", "Cooley", "Cooper", "Copeland", "Cortez", "Cote", "Cotton", "Cox", "Craft", "Craig", "Crane", "Crawford", "Crosby", "Cross", "Cruz", "Cummings", "Cunningham", "Curry", "Curtis", "Dale", "Dalton", "Daniel", "Daniels", "Daugherty", "Davenport", "David", "Davidson", "Davis", "Dawson", "Day", "De La Cruz", "Dean", "Decker", "Dejesus", "Delaney", "Deleon", "Delgado", "Dennis", "Diaz", "Dickerson", "Dickson", "Dillard", "Dillon", "Dixon", "Dodson", "Dominguez", "Donaldson", "Donovan", "Dorsey", "Dotson", "Douglas", "Downs", "Doyle", "Drake", "Dudley", "Duffy", "Duke", "Duncan", "Dunlap", "Dunn", "Duran", "Durham", "Dyer", "Eaton", "Edwards", "Elliott", "Ellis", "Ellison", "Emerson", "England", "English", "Erickson", "Espinoza", "Estes", "Estrada", "Evans", "Everett", "Ewing", "Farley", "Farmer", "Farrell", "Faulkner", "Ferguson", "Fernandez", "Ferrell", "Fields", "Figueroa", "Finch", "Finley", "Fischer", "Fisher", "Fitzgerald", "Fitzpatrick", "Fleming", "Fletcher", "Flores", "Flowers", "Floyd", "Flynn", "Foley", "Forbes", "Ford", "Foreman", "Foster", "Fowler", "Fox", "Francis", "Franco", "Frank", "Franklin", "Franks", "Frazier", "Frederick", "Freeman", "French", "Frost", "Fry", "Frye", "Fuentes", "Fuller", "Fulton", "Gaines", "Gallagher", "Gallegos", "Galloway", "Gamble", "Garcia", "Gardner", "Garner", "Garrett", "Garrison", "Garza", "Gates", "Gay", "Gentry", "George", "Gibbs", "Gibson", "Gilbert", "Giles", "Gill", "Gillespie", "Gilliam", "Gilmore", "Glass", "Glenn", "Glover", "Goff", "Golden", "Gomez", "Gonzales", "Gonzalez", "Good", "Goodman", "Goodwin", "Gordon", "Gould", "Graham", "Grant", "Graves", "Gray", "Green", "Greene", "Greer", "Gregory", "Griffin", "Griffith", "Grimes", "Gross", "Guerra", "Guerrero", "Guthrie", "Gutierrez", "Guy", "Guzman", "Hahn", "Hale", "Haley", "Hall", "Hamilton", "Hammond", "Hampton", "Hancock", "Haney", "Hansen", "Hanson", "Hardin", "Harding", "Hardy", "Harmon", "Harper", "Harrell", "Harrington", "Harris", "Harrison", "Hart", "Hartman", "Harvey", "Hatfield", "Hawkins", "Hayden", "Hayes", "Haynes", "Hays", "Head", "Heath", "Hebert", "Henderson", "Hendricks", "Hendrix", "Henry", "Hensley", "Henson", "Herman", "Hernandez", "Herrera", "Herring", "Hess", "Hester", "Hewitt", "Hickman", "Hicks", "Higgins", "Hill", "Hines", "Hinton", "Hobbs", "Hodge", "Hodges", "Hoffman", "Hogan", "Holcomb", "Holden", "Holder", "Holland", "Holloway", "Holman", "Holmes", "Holt", "Hood", "Hooper", "Hoover", "Hopkins", "Hopper", "Horn", "Horne", "Horton", "House", "Houston", "Howard", "Howe", "Howell", "Hubbard", "Huber", "Hudson", "Huff", "Huffman", "Hughes", "Hull", "Humphrey", "Hunt", "Hunter", "Hurley", "Hurst", "Hutchinson", "Hyde", "Ingram", "Irwin", "Jackson", "Jacobs", "Jacobson", "James", "Jarvis", "Jefferson", "Jenkins", "Jennings", "Jensen", "Jimenez", "Johns", "Johnson", "Johnston", "Jones", "Jordan", "Joseph", "Joyce", "Joyner", "Juarez", "Justice", "Kane", "Kaufman", "Keith", "Keller", "Kelley", "Kelly", "Kemp", "Kennedy", "Kent", "Kerr", "Key", "Kidd", "Kim", "King", "Kinney", "Kirby", "Kirk", "Kirkland", "Klein", "Kline", "Knapp", "Knight", "Knowles", "Knox", "Koch", "Kramer", "Lamb", "Lambert", "Lancaster", "Landry", "Lane", "Lang", "Langley", "Lara", "Larsen", "Larson", "Lawrence", "Lawson", "Le", "Leach", "Leblanc", "Lee", "Leon", "Leonard", "Lester", "Levine", "Levy", "Lewis", "Lindsay", "Lindsey", "Little", "Livingston", "Lloyd", "Logan", "Long", "Lopez", "Lott", "Love", "Lowe", "Lowery", "Lucas", "Luna", "Lynch", "Lynn", "Lyons", "MacDonald", "Macias", "Mack", "Madden", "Maddox", "Maldonado", "Malone", "Mann", "Manning", "Marks", "Marquez", "Marsh", "Marshall", "Martin", "Martinez", "Mason", "Massey", "Mathews", "Mathis", "Matthews", "Maxwell", "May", "Mayer", "Maynard", "Mayo", "Mays", "McBride", "McCall", "McCarthy", "McCarty", "McClain", "McClure", "McConnell", "McCormick", "McCoy", "McCray", "McCullough", "McDaniel", "McDonald", "McDowell", "McFadden", "McFarland", "McGee", "McGowan", "McGuire", "McIntosh", "McIntyre", "McKay", "McKee", "McKenzie", "McKinney", "McKnight", "McLaughlin", "McLean", "McMahon", "McMillan", "McNeil", "McPherson", "Meadows", "Medina", "Mejia", "Melendez", "Melton", "Mendez", "Mendoza", "Mercado", "Mercer", "Merrill", "Merritt", "Meyer", "Meyers", "Michael", "Middleton", "Miles", "Miller", "Mills", "Miranda", "Mitchell", "Molina", "Monroe", "Montgomery", "Montoya", "Moody", "Moon", "Mooney", "Moore", "Morales", "Moran", "Moreno", "Morgan", "Morin", "Morris", "Morrison", "Morrow", "Morse", "Morton", "Moses", "Mosley", "Moss", "Mueller", "Mullen", "Mullins", "Munoz", "Murphy", "Murray", "Myers", "Nash", "Navarro", "Neal", "Nelson", "Newman", "Newton", "Nguyen", "Nichols", "Nicholson", "Nielsen", "Nieves", "Nixon", "Noble", "Noel", "Nolan", "Norman", "Norris", "Norton", "Nunez", "O'Brien", "O'Connor", "O'Donnell", "O'Neil", "O'Neill", "Ochoa", "Odom", "Oliver", "Olsen", "Olson", "Oneal", "Orr", "Ortega", "Ortiz", "Osborn", "Osborne", "Owen", "Owens", "Pace", "Pacheco", "Padilla", "Page", "Palmer", "Park", "Parker", "Parks", "Parrish", "Parsons", "Pate", "Patel", "Patrick", "Patterson", "Patton", "Paul", "Payne", "Pearson", "Peck", "Pena", "Pennington", "Perez", "Perkins", "Perry", "Peters", "Petersen", "Peterson", "Petty", "Phelps", "Phillips", "Pickett", "Pierce", "Pittman", "Pitts", "Pollard", "Poole", "Pope", "Porter", "Potter", "Potts", "Powell", "Powers", "Pratt", "Preston", "Price", "Prince", "Pruitt", "Puckett", "Pugh", "Quinn", "Ramirez", "Ramos", "Ramsey", "Randall", "Randolph", "Rasmussen", "Ratliff", "Ray", "Raymond", "Reed", "Reese", "Reeves", "Reid", "Reilly", "Reyes", "Reynolds", "Rhodes", "Rice", "Rich", "Richard", "Richards", "Richardson", "Richmond", "Riddle", "Riggs", "Riley", "Rios", "Rivas", "Rivera", "Rivers", "Roach", "Robbins", "Roberson", "Roberts", "Robertson", "Robinson", "Robles", "Rocha", "Rodgers", "Rodriguez", "Rodriquez", "Rogers", "Rojas", "Rollins", "Roman", "Romero", "Rosa", "Rosales", "Rosario", "Rose", "Ross", "Roth", "Rowe", "Rowland", "Roy", "Ruiz", "Rush", "Russell", "Russo", "Rutledge", "Ryan", "Salas", "Salazar", "Salinas", "Sampson", "Sanchez", "Sanders", "Sandoval", "Sanford", "Santana", "Santiago", "Santos", "Sargent", "Saunders", "Savage", "Sawyer", "Schmidt", "Schneider", "Schroeder", "Schultz", "Schwartz", "Scott", "Sears", "Sellers", "Serrano", "Sexton", "Shaffer", "Shannon", "Sharp", "Sharpe", "Shaw", "Shelton", "Shepard", "Shepherd", "Sheppard", "Sherman", "Shields", "Short", "Silva", "Simmons", "Simon", "Simpson", "Sims", "Singleton", "Skinner", "Slater", "Sloan", "Small", "Smith", "Snider", "Snow", "Snyder", "Solis", "Solomon", "Sosa", "Soto", "Sparks", "Spears", "Spence", "Spencer", "Stafford", "Stanley", "Stanton", "Stark", "Steele", "Stein", "Stephens", "Stephenson", "Stevens", "Stevenson", "Stewart", "Stokes", "Stone", "Stout", "Strickland", "Strong", "Stuart", "Suarez", "Sullivan", "Summers", "Sutton", "Swanson", "Sweeney", "Sweet", "Sykes", "Talley", "Tanner", "Tate", "Taylor", "Terrell", "Terry", "Thomas", "Thompson", "Thornton", "Tillman", "Todd", "Torres", "Townsend", "Tran", "Travis", "Trevino", "Trujillo", "Tucker", "Turner", "Tyler", "Tyson", "Underwood", "Valdez", "Valencia", "Valentine", "Valenzuela", "Vance", "Vang", "Vargas", "Vasquez", "Vaughan", "Vaughn", "Vazquez", "Vega", "Velasquez", "Velazquez", "Velez", "Villarreal", "Vincent", "Vinson", "Wade", "Wagner", "Walker", "Wall", "Wallace", "Waller", "Walls", "Walsh", "Walter", "Walters", "Walton", "Ward", "Ware", "Warner", "Warren", "Washington", "Waters", "Watkins", "Watson", "Watts", "Weaver", "Webb", "Weber", "Webster", "Weeks", "Weiss", "Welch", "Wells", "West", "Wheeler", "Whitaker", "White", "Whitehead", "Whitfield", "Whitley", "Whitney", "Wiggins", "Wilcox", "Wilder", "Wiley", "Wilkerson", "Wilkins", "Wilkinson", "William", "Williams", "Williamson", "Willis", "Wilson", "Winters", "Wise", "Witt", "Wolf", "Wolfe", "Wong", "Wood", "Woodard", "Woods", "Woodward", "Wooten", "Workman", "Wright", "Wyatt", "Wynn", "Yang", "Yates", "York", "Young", "Zamora", "Zimmerman"
    };
    private static final String smartPhoneModels[] = {"Samsung Galaxy S III" //, "Xiaomi Mi 2", "Samsung Galaxy S4", "Nokia", "Apple iPhone", "iPhone 6", "iPhone 6 Plus", "iPhone 5s", "Samsung Galaxy S4", "Samsung Galaxy S5", "iPhone 4s", "HTC One M8", "Samsung Galaxy S III", "Samsung Galaxy Note 3", "iPhone 7", "Samsung Galaxy S7", "Redmi note 3", "OnePlus 3t", "Redmi 3s prime", "Lenovo K4 note", "Samsung Galaxy Note9", "Huawei P20", "IPhone XS", "Samsung Galaxy S9", "Samsung Galaxy S9 Plus", "Samsung Galaxy s9 Lite"
    };

    public static List<Attendance> getAttendance(String startTime) {
        Random random = new Random();
        int size = 30 + random.nextInt(30);
        Date zeroTime = TIMESTAMP_FORMAT.parse(startTime, new ParsePosition(0));
        List<Attendance> attendanceList = new ArrayList<>(size);
        List<String> peopleNames = generatePeopleNameList(size);
        List<String> macList = generateMacList(size);
        for (int i = 0; i < size; i++) {
            Attendance attendance = new Attendance();
            attendance.confidence = random.nextFloat();
            attendance.distance = 0.2f + random.nextFloat() * 5.0f;
            Date lastHit = new Date(zeroTime.getTime() + random.nextInt(50 * 60_000));
            attendance.lastHit = TIMESTAMP_FORMAT.format(lastHit);
            attendance.macAddress = macList.get(i);
            attendance.personName = peopleNames.get(i);
            attendanceList.add(attendance);
        }
        return attendanceList;
    }

    private static List<String> generatePeopleNameList(int size) {
        List<String> list = new ArrayList<>(size);
        final Random random = new Random();
        for (int i = 0; i < size; i++) {
            int mfn = random.nextInt(3); // male, female, null
            if (mfn == 2) {
                list.add(null);
            } else {
                String name;
                String surname;
                if (mfn == 0) {
                    name = maleNames[random.nextInt(maleNames.length)];
                } else {
                    name = femaleNames[random.nextInt(femaleNames.length)];
                }
                surname = surnames[random.nextInt(surnames.length)];
                list.add(String.format("%s %s", name, surname));
            }
        }
        return list;
    }

    private static List<String> generateMacList(int size) {
        final Random random = new Random();
        List<String> macList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            macList.add(String.format("%02x:%02x:%02x:%02x:%02x:%02x",
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)));
        }
        return macList;
    }

    public static List<Person> getPeopleList() {
        List<Person> people;
        List<String> names;
        List<String> macs;
        List<String> models;
        final Random random = new Random();
        int size = 30 + random.nextInt(30);
        people = new ArrayList<>(size);
        names = generatePeopleNameList(size);
        macs = generateMacList(size);
        models = generateModelList(size);
        for (int i = 0; i < size; i++) {
            Person person = new Person();
            person.name = names.get(i);
            person.deviceMac = macs.get(i);
            person.deviceModel = models.get(i);
            people.add(person);
        }
        return people;
    }

    private static List<String> generateModelList(int size) {
        List<String> models = new ArrayList<>(size);
        final Random random = new Random();
        for (int i = 0; i < size; i++) {
            models.add(smartPhoneModels[random.nextInt(smartPhoneModels.length)]);
        }
        return models;
    }

    public static List<Attendance> getAttendanceOfMac(String mac) {
        String personName = generatePeopleNameList(1).get(0);
        List<String> sessions = getSessionList();
        Random random = new Random();
        float attendance = 0.5f + random.nextFloat() * 0.5f;
        List<Attendance> attendanceList = new ArrayList<>(sessions.size());
        for (String session : sessions) {
            Attendance a = new Attendance();
            a.personName = personName;
            a.macAddress = mac;
            if (random.nextFloat() > attendance) {
                // absent
                a.lastHit = "";
                a.distance = 0;
                a.confidence = 1.0f;
            } else {
                Date zeroTime = TIMESTAMP_FORMAT.parse(session, new ParsePosition(0));
                Date lastHit = new Date(zeroTime.getTime() + random.nextInt(50 * 60_000));
                a.lastHit = TIMESTAMP_FORMAT.format(lastHit);
                a.distance = 0.2f + random.nextFloat() * 5.0f;
                a.confidence = random.nextFloat();
            }
            attendanceList.add(a);
        }
        return attendanceList;
    }

    public static List<String> getSessionList() {
        Random random = new Random();
        int size = 10 + random.nextInt(10);
        Date before = new Date();
        List<String> sessionList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            before.setTime(before.getTime() - 85_800_000 + random.nextInt(1_200_000));
            sessionList.add(TIMESTAMP_FORMAT.format(before));
        }
        return sessionList;
    }

    public static List<MapJoins> getJoins(boolean isNewJoin) {
        Random random = new Random();
        int size;
        if (isNewJoin) {
            size = 2 + random.nextInt(5);
        } else {
            size = 20 + random.nextInt(20);
        }

        List<MapJoins> mapJoinsList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int gender = random.nextInt(2);
            String name;
            String surname;
            if (gender == 0) {
                name = maleNames[random.nextInt(maleNames.length)];
            } else {
                name = femaleNames[random.nextInt(femaleNames.length)];
            }
            surname = surnames[random.nextInt(surnames.length)];
            MapJoins mapJoin = new MapJoins(String.format("%s %s", name, surname));
            mapJoinsList.add(mapJoin);
        }

        return mapJoinsList;
    }
}
