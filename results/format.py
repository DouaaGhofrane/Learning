
with open("cas-tests.txt", 'r') as infile:
    lines = infile.readlines()
with open("new-cases.txt", 'w') as outfile:
    for line in lines:     
        formatted_line = ' '.join(line.split())
        outfile.write(formatted_line + '\n')

