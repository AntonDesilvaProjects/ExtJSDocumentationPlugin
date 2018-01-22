import sublime
import sublime_plugin
import urllib
import threading

from urllib.request import urlopen

class ExtJsDocConnection(threading.Thread):
	def __init__(self,query, timeout):
		super(ExtJsDocConnection,self).__init__()
		self.query = query
		self.timeout = timeout

	def run(self):
		try:
			request = urllib.request.Request('http://localhost:3000/DocumentationServer/ui/getDocumentation?q='+ self.query)
			http_file = urlopen(request, timeout=self.timeout)
			self.result = http_file.read().decode('UTF-8')
			print(self.result)
			return
		except (urllib.error.HTTPError) as e:
			err = str(e.reason)
		except (urllib.error.URLError) as e:
			err = str(e.reason)

		sublime.error_message(err)
		return False

class ExtJsDocCommand(sublime_plugin.TextCommand):
	def run(self, edit):
		selectionIndices = self.view.sel()
		docQueryThreads = []
		for selectionIndex in selectionIndices:
			selection = self.view.substr(selectionIndex) 
			queryThread = ExtJsDocConnection( selection, 10 )
			docQueryThreads.append( queryThread )
			queryThread.start();