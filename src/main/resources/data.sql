-- /populate-db failure backup plan

INSERT INTO author (first_name, last_name) VALUES
('Chuckling', 'Charlie'),
('Jenny', 'Jests'),
('Hailey', 'Humor'),
('Larry', 'Laughs');

INSERT INTO joke (author_id, setup, punchline) VALUES
(1, 'I told my wife she was drawing her eyebrows too high.', 'She looked surprised.'),
(1, 'I threw a boomerang a few years ago.', 'I now live in constant fear.'),
(1, 'Why don’t skeletons fight each other?', 'They don’t have the guts.'),
(2, 'What do you call fake spaghetti?', 'An impasta.'),
(2, 'What do you call a man with a rubber toe?', 'Roberto.'),
(2, 'What did the janitor say when he jumped out of the closet?', 'Supplies!'),
(3, 'What’s orange and sounds like a parrot?', 'A carrot.'),
(3, 'Why couldn’t the bicycle stand up by itself?', 'It was two tired.'),
(3, 'Why don’t we ever tell secrets on a farm?', 'Because the potatoes have eyes and the corn has ears.'),
(3, 'Why did the scarecrow win an award?', 'Because he was outstanding in his field.'),
(2, 'What do you call an alligator in a vest?', 'An investigator.'),
(1, 'Why don’t eggs tell jokes?', 'They’d crack each other up.'),
(2, 'I’m reading a book on anti-gravity.', 'It’s impossible to put down.'),
(3, 'What do you call a factory that makes okay products?', 'A satisfactory.'),
(2, 'Why don’t scientists trust atoms?', 'Because they make up everything.'),
(1, 'What do you call a belt made out of watches?', 'A waist of time.'),
(2, 'Why did the old man fall in the well?', 'Because he couldn’t see that well.'),
(3, 'What do you call a singing Laptop?', 'A Dell.'),
(2, 'How does a penguin build its house?', 'Igloos it together.'),
(1, 'Why did the math book look sad?', 'Because it had too many problems.'),
(2, 'What has ears but cannot hear?', 'A cornfield.'),
(3, 'Why can’t you give Elsa a balloon?', 'Because she will let it go.'),
(2, 'What do you get when you cross a snowman and a vampire?', 'Frostbite.'),
(1, 'Get your facts first, then you can distort them as you please.', ''),
(1, 'The secret of getting ahead is getting started.', ''),
(1, 'Age is an issue of mind over matter. If you don’t mind, it doesn’t matter.', ''),
(2, 'My grandmother started walking five miles a day when she was sixty.', 'She’s ninety-seven now, and we don’t know where the heck she is.'),
(2, 'I really don’t think I need buns of steel.', 'I’d be happy with buns of cinnamon.'),
(2, 'You know, it’s hard work to write a book.', 'I can’t tell you how many times I really get going on an idea, then my quill breaks.'),
(3, 'I’m against picketing, but I don’t know how to show it.', ''),
(3, 'Rice is great if you’re really hungry and want to eat two thousand of something.', ''),
(3, 'I once saw a forklift lift a crate of forks.', 'And it was way too literal for me.'),
(4, 'I like to crack the jokes now and again, but it’s only because I struggle with math.', ''),
(4, 'If you want to make an audience laugh, you dress a man up like an old lady and push her down the stairs.', 'If you want to make comedy writers laugh, you push an actual old lady down the stairs.'),
(4, 'Being a mom has made me so tired.', 'And so happy.');