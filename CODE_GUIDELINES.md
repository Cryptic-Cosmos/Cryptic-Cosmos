# Code Guidelines
## Java
### General advice
When writing code, if shortening the code will make it longer, but making it longer will make it more readable, always go for the longer and more readable code. We don't write code for computers. We write it for humans.

### Specifics
#### Required
- Put a new line after any control flow statements, unless the control flow statement is a one liner.
- Put a new line before a return, unless the method is a one liner.
- Use `UpperCamelCase` for class names. Use `lowerCamelCase` for method names, variable names, and names of fields that are not
both static and final. Use `UPPER_SNAKE_CASE` for names of fields that are both static and final.
- Method names should generally be verb phrases (`tick`, `getCarversForStep`), except for "withX", "toX", "fromX", "of" and
builder methods.
- Class names and non-boolean field and variable names should be noun phrases (`ChunkRegion`, `color`).
- Boolean field and variable names should always be adjective phrases or present tense verb phrases (`powered`, `canOpen`),
avoiding the `is` and `has` prefixes when possible (`colored`, not `isColored` or `hasColor`).
- To make code as easy to read as possible, keep names in the natural language order.
- Use American English for consistency.
- Omit words that are made redundant by parameter names or owner class names.
- Treat acronyms as single words rather than capitalising every letter. This improves readability (compare `JsonObject` and
`JSONObject`).

#### Recommended
- Enum constants should be in `THE_NAME` format.
- Prefer method references over lambdas.
- Package names should always be singular to respect Java conventions.

#### Do not
- Do not put multiple statements on one line.
- Do not prefix class names with `I`/`Interface` or `E`/`Enum`.

#### Refrain
- Refrain from trailing semicolons, except in enums.
- Avoid abbreviations unless it's a common one everyone knows.

##### Java Conventions Notes
**This is not an exhaustive list.**  
The people over at FabricMC have created wonderful, more in-depth conventions. [See it here.](https://github.com/FabricMC/yarn/blob/20w46a/CONVENTIONS.md)

### Note
This document was last edited 2020-11-18 22:34:35 UTC (ISO 8601).
**Please check regularly to see if there are any changes.**
