Add ExtJSDocs to \Sublime Text 3\Packages

Add key mapping:

[
	{ "keys": ["alt+;"], "command": "ext_js_doc" }
]

url - complete system file path of the ext js html files. Used to read in and index the files
root - anything in the browser URL starting with {localhost:3000/docs} go to this directory
prefix - used to created a relative URL for individual files. We create following URL {/docs/[prefix]/fileName.extension}